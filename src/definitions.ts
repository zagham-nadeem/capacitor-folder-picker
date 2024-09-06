export interface FolderPickerPlugin {
  chooseFolder(): Promise<{ path: string }>;
}
