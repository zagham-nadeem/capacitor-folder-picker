import { registerPlugin } from '@capacitor/core';

import type { FolderPickerPlugin } from './definitions';

const FolderPicker = registerPlugin<FolderPickerPlugin>('FolderPicker', {
  web: () => import('./web').then(m => new m.FolderPickerWeb()),
});

export * from './definitions';
export { FolderPicker };
