package storage;

import model.Resume;



/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage{

    public void insert(Resume r)
    {
            storage[size] = r;
    }


    public void recount(int index)
    {
            storage[index] = storage[size - 1];
    }


    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
