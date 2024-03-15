export interface FolderPickerPlugin {
  chooseFolder(): Promise<{ value: string }>;
}
