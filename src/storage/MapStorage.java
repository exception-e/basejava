package storage;

import model.Resume;

import java.util.Map;

public class MapStorage extends AbstractStorage{

    protected Map<Integer, Resume> storage;

    @Override
    public void clear() {
        storage.clear();

    }

    @Override
    public void update(Resume r) {
        super.update(r);
    }

    @Override
    public void save(Resume r) {
        super.save(r);
    }

    @Override
    public Resume get(String uuid) {
        return super.get(uuid);
    }

    @Override
    public void delete(String uuid) {
        super.delete(uuid);
    }

    @Override
    public Resume[] getAll() {
        return super.getAll();
    }
}
