import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


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

        List<Resume>  resumeList = new ArrayList<>(Arrays.asList(getAll()));
        resumeList.add(r);

        resumeList.toArray(storage);

    }

    Resume get(String uuid) {
        List<Resume>  resumeList = new ArrayList<>(Arrays.asList(getAll()));
        Resume resume1 = new Resume();
        try {
            return resumeList.stream().filter(resume -> resume.uuid.equals(uuid)).findFirst().get();
        }
        catch (Exception e)
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
        List<Resume> resultStorage;

        resultStorage = new ArrayList<>(Arrays.asList(storage)).stream().filter(r-> r != null).collect(Collectors.toList());

        Resume[] resumes = new Resume[resultStorage.size()];
        return resultStorage.toArray(resumes);
        /*for(Resume r : storage)
        {
            if (r != null)
                resultStorage.add(r);
        }
        Resume[] resumes = new Resume[100];
        return resultStorage.toArray(resumes);*/
    }

    int size() {
        storage = getAll();

        return storage.length;
    }
}
