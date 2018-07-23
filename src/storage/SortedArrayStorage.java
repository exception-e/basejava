package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{


    @Override
    public void insertElement(Resume r, int index)
    {
        int j = -index - 1;
        System.arraycopy(storage, j, storage, j+1, size - j);
        storage[j] = r;

    }

    @Override
    public void recount(int index) {
            for(int i = index; i < size; i++)
            {
                storage[i] = storage[i+1];
            }

    }


    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}