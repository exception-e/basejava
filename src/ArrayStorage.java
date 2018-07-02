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

    void save(Resume resume) {
        List<Resume>  resumeList = Arrays.asList(getAll());
        if(resumeList.contains(resume)) {
            update(resume);
        }
        else {
            resumeList.add(resume);
            resumeList.toArray(storage);
        }
    }


    void update(Resume resume) {
        List<Resume>  resumeList = Arrays.asList(getAll());
        if(resumeList.contains(resume)) {
            Resume r = resumeList.stream().filter(res -> res.uuid.equals(resume.uuid)).findFirst().get();

            storage[resumeList.indexOf(r)] = resume;
        }
        else
            System.out.println("Resume not found");
    }


    Resume get(String uuid) {
        List<Resume>  resumeList = Arrays.asList(getAll());
        if(resumeList.stream().anyMatch(res -> res.uuid.equals(uuid))) {
            return resumeList.stream().filter(res -> res.uuid.equals(uuid)).findFirst().get();

        }
        else
            System.out.println("Resume not found");
        return null;
    }

    void delete(String uuid) {
        List<Resume>  resumeList = Arrays.asList(getAll());
        if(resumeList.stream().anyMatch(res -> res.uuid.equals(uuid))) {
            Resume r = (resumeList.stream().filter(resume -> resume.uuid.equals(uuid)).findFirst().get());
            resumeList.toArray(storage);
            storage[resumeList.indexOf(r)] = null;
        }
        else
            System.out.println("Resume not found");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        List<Resume> resultStorage;

        resultStorage = Arrays.stream(storage).filter(Objects::nonNull).collect(Collectors.toList());

        Resume[] resumes = new Resume[resultStorage.size()];

        return resultStorage.toArray(resumes);
    }

    int size() {
        storage = getAll();
        return storage.length;
    }
}
