package fr.benoit.lftestand.data;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Singleton used to write and read data from disk.
 *
 * Created by benoit on 06/02/2016.
 */
public class FileManager {

    private static final String TAG = "FileManager";

    public static final String DIRECTORY_RESTAURANT = "restaurants";

    private String path;

    private static FileManager sInstance;

    private static final Object __synchonizedObject = new Object();

    private FileManager(Context context) {
        path = context.getExternalCacheDir() + "/cache_lf/";
    }

    public static FileManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (__synchonizedObject) {
                if (sInstance == null)
                    sInstance = new FileManager(context);
            }
        }
        return sInstance;
    }

    public void saveObject(Serializable object, String fileName, String directory) {
        if (object != null){
            fileName += ".ser";
            Log.i(TAG,
                    "save object : " + object.getClass() + " in : " + path + fileName);
            try {

                deleteFile(path + fileName, directory);

                File file;
                if (directory != null && directory.length() > 0){
                    File directoryFile = new File(path + File.separator + directory + File.separator);
                    if (!directoryFile.exists()){
                        directoryFile.mkdirs();
                    }
                    file = new File(directoryFile, fileName);
                }else{
                    file = new File(path, fileName);
                }

                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(object);
                oos.flush();
                oos.close();
                Log.i(TAG,
                        "object saved : " + object.getClass() + " in : " + path + fileName);
            } catch (IOException e) {
                Log.d(TAG, "Cannot save object" + path + File.separator + directory + fileName + " " + e);
            }
        }

    }

    public Object loadObject(String fileName, String directory) {
        Object object = null;
        fileName += ".ser";
        Log.i(TAG, "load object " + path + fileName);

        try {
            File file;
            if (directory != null && directory.length() > 0){
                File directoryFile = new File(path + File.separator + directory + File.separator);
                if (!directoryFile.exists()){
                    directoryFile.mkdirs();
                }
                file = new File(directoryFile, fileName);
            }else{
                file = new File(path, fileName);
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();
            ois.close();
            fis.close();
        } catch (java.io.IOException e) {
            Log.d(TAG,
                    "Cannot load object from file : " + path + File.separator + directory + fileName);
        } catch (ClassNotFoundException e) {
            Log.d(TAG,
                    "Cannot load object from file : " + path + File.separator + directory + fileName);
        }

        return object;
    }

    public void deleteFile(String fileName, String directory) {
        Log.i(TAG, "deleting " + path + directory + fileName);
        File file;
        if (directory != null && directory.length() > 0){
            File directoryFile = new File(path + File.separator + directory + File.separator);
            if (!directoryFile.exists()){
                directoryFile.mkdirs();
            }
            file = new File(directoryFile, fileName);
        }else{
            file = new File(path, fileName);
        }
        file.delete();
    }

    public void deleteFile(String pathToFile) {
        File file = new File (pathToFile);
        if (file.exists()){
            file.delete();
        }
    }
}
