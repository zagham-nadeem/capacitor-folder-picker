import { WebPlugin } from '@capacitor/core';

import type { FolderPickerPlugin } from './definitions';

export class FolderPickerWeb extends WebPlugin implements FolderPickerPlugin {
  async chooseFolder(): Promise<{ value: string; }> {
    throw this.unimplemented('Not implemented on web.');
  }
  
}
