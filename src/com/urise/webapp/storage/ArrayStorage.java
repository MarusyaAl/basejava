package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void deleteZeroInTheMiddle(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void putElementIntoStorage(Resume resume) {
        storage[size] = resume;
    }
}