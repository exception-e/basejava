import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.setAll(storage, null );
    }

    void save(Resume r) {
        int pos = storage.length;
        storage[pos +1] = r;

    }

    Resume get(String uuid) {
        List<Resume>  resumeList = Arrays.asList(getAll());
        Resume r = ((Resume) resumeList.stream().filter(resume -> resume.uuid.equals(uuid)));
        return r;
    }

    void delete(String uuid) {
        List<Resume>  resumeList = Arrays.asList(getAll());
        Resume r = ((Resume) resumeList.stream().filter(resume -> resume.uuid.equals(uuid)));
        resumeList.remove(r);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        List<Resume> resultStorage = new ArrayList<>();
        for(Resume r : storage)
        {
            if (r!=null)
            {
                resultStorage.add(r);
            }
        }
        return (Resume[])resultStorage.toArray();
    }

    int size() {
        return getAll().length;
    }
}
