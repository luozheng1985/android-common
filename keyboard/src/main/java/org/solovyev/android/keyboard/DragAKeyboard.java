/*
 * Copyright 2013 serso aka se.solovyev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ---------------------------------------------------------------------
 * Contact details
 *
 * Email: se.solovyev@gmail.com
 * Site:  http://se.solovyev.org
 */

package org.solovyev.android.keyboard;

import android.content.res.Resources;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: serso
 * Date: 11/3/12
 * Time: 1:45 PM
 */
public class DragAKeyboard extends AbstractAKeyboard {

    @NotNull
    private final KeyboardDef keyboardDef;

    public DragAKeyboard(@NotNull String keyboardId, @NotNull KeyboardDef keyboardDef) {
		super(keyboardId);
		this.keyboardDef = keyboardDef;
    }

    @Override
    public void setImeOptions(@NotNull Resources resources, int imeOptions) {
        keyboardDef.setImeOptions(resources, imeOptions);
    }

    @Override
    public void setShifted(boolean shifted) {
        keyboardDef.setShifted(shifted);
    }

    @NotNull
    public KeyboardDef getKeyboardDef() {
        return keyboardDef;
    }

    public static final class KeyboardDef {

        @NotNull
        private final List<RowDef> rowDefs = new ArrayList<RowDef>();

        public KeyboardDef() {
        }

        public boolean add(RowDef object) {
            return rowDefs.add(object);
        }

        private void clear() {
            rowDefs.clear();
        }

        @NotNull
        public List<RowDef> getRowDefs() {
            return Collections.unmodifiableList(rowDefs);
        }

		public void setImeOptions(@NotNull Resources resources, int imeOptions) {
			for (RowDef rowDef : rowDefs) {
				rowDef.setImeOptions(resources, imeOptions);
			}
		}

		public void setShifted(boolean shifted) {
			for (RowDef rowDef : rowDefs) {
				rowDef.setShifted(shifted);
			}
		}
	}

    public static final class RowDef {

        @NotNull
        private final List<DragAKeyboardButtonDef> buttonDefs = new ArrayList<DragAKeyboardButtonDef>();

        public RowDef() {
        }

        public boolean add(@NotNull DragAKeyboardButtonDef dragButtonDef) {
            return buttonDefs.add(dragButtonDef);
        }

        private void clear() {
            buttonDefs.clear();
        }

        @NotNull
        public List<DragAKeyboardButtonDef> getButtonDefs() {
            return Collections.unmodifiableList(buttonDefs);
        }

		public void setImeOptions(@NotNull Resources resources, int imeOptions) {
			for (DragAKeyboardButtonDef buttonDef : buttonDefs) {
				buttonDef.setImeOptions(resources, imeOptions);
			}
		}

		public void setShifted(boolean shifted) {
			for (DragAKeyboardButtonDef buttonDef : buttonDefs) {
				buttonDef.setShifted(shifted);
			}
		}
    }
}
