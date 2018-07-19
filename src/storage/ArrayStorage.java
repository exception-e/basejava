package storage;

import model.Resume;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    public void clear() {
        Arrays.fill(storage, null);
    }

    public void save(Resume resume) {
        List<Resume>  resumeList = Arrays.asList(getAll());
        if(resumeList.contains(resume)) {
            update(resume);
        }
        else {
            resumeList.add(resume);
            resumeList.toArray(storage);
        }
    }


    public void update(Resume resume) {
        List<Resume>  resumeList = Arrays.asList(getAll());
        if(resumeList.contains(resume)) {
            Resume r = resumeList.stream().filter(res -> res.getUuid().equals(resume.getUuid())).findFirst().get();

            storage[resumeList.indexOf(r)] = resume;
        }
        else
            System.out.println("Resume not found");
    }


    public Resume get(String uuid) {
        List<Resume>  resumeList = Arrays.asList(getAll());
        if(resumeList.stream().anyMatch(res -> res.getUuid().equals(uuid))) {
            return resumeList.stream().filter(res -> res.getUuid().equals(uuid)).findFirst().get();

        }
        else
            System.out.println("Resume not found");
        return null;
    }

    public void delete(String uuid) {
        List<Resume>  resumeList = Arrays.asList(getAll());
        if(resumeList.stream().anyMatch(res -> res.getUuid().equals(uuid))) {
            Resume r = (resumeList.stream().filter(resume -> resume.getUuid().equals(uuid)).findFirst().get());
            resumeList.toArray(storage);
            storage[resumeList.indexOf(r)] = null;
        }
        else
            System.out.println("Resume not found");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        List<Resume> resultStorage;

        resultStorage = Arrays.stream(storage).filter(Objects::nonNull).collect(Collectors.toList());

        Resume[] resumes = new Resume[resultStorage.size()];

        return resultStorage.toArray(resumes);
    }

    public int size() {
        storage = getAll();
        return storage.length;
    }
}
