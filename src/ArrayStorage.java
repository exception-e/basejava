import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[100];

    void clear() {

        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        Resume[] resumes = getAll();
        int pos=0;
        for(int i = 0; i < resumes.length; i++)
        {
            if(resumes[i] == null)
            {
                pos = i;
                break;

            }
        }
        resumes[pos] = r;
        storage = resumes;

    }

    Resume get(String uuid) {
        List<Resume>  resumeList = Arrays.asList(getAll());
        try {
            return resumeList.stream().filter(resume -> resume.uuid.equals(uuid)).findFirst().get();
        }
        catch (NullPointerException npe)
        {
            System.out.println("No such resume");
        }

            return null;


    }

    void delete(String uuid) {
        List<Resume>  resumeList = Arrays.asList(getAll());
        Resume r = (resumeList.stream().filter(resume -> resume.uuid.equals(uuid)).findFirst().get());
        resumeList.toArray(storage);
        storage[resumeList.indexOf(r)] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        List<Resume> resultStorage = new ArrayList<>();
        for(Resume r : storage)
        {
            if (r != null)
                resultStorage.add(r);
        }
        Resume[] resumes = new Resume[100];
        return resultStorage.toArray(resumes);
    }

    int size() {
        storage = getAll();
        int size = 0;
        for(int i = 0; i < storage.length; i++)
        {
            if(storage[i] == null)
            {
                size = i;
                break;

            }
        }
        return size;
    }
}
