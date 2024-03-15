# Folder Picker Plugin

Folder Picker is a Capacitor plugin for selecting a folder from the device's storage.

## Installation

To use Folder Picker in your Capacitor project, follow these steps:

1. Install the plugin using npm:

   ```bash
   npm install capacitor-folder-picker
   ```

2. For Android, ensure that you have the necessary permissions in your `AndroidManifest.xml`:

   ```xml
   <manifest ...>

       <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
       <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />

       <application ...>
           ...
       </application>

   </manifest>
   ```

   Make sure to request runtime permissions if targeting Android API 23 or higher.

3. Register the plugin in your `MainActivity.java` or wherever you initialize Capacitor plugins:

   ```java
   public class MainActivity extends BridgeActivity {
       @Override
       public void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           // Additional initialization code goes here
       }
   }
   ```

## Usage

### Example

```javascript
import { FolderPicker } from 'capacitor-folder-picker';

async function pickFolder() {
    const result = await FolderPicker.chooseFolder();
    console.log('Selected folder path:', result.path);
}
```

### API

#### chooseFolder()

Opens a system file picker dialog to select a folder.

- **Returns:** Promise\<{ path: string }\> - A promise that resolves with the selected folder path.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
