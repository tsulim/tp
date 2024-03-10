package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyStaffConnect;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of StaffConnect data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private StaffConnectStorage staffConnectStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code StaffConnectStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(StaffConnectStorage staffConnectStorage, UserPrefsStorage userPrefsStorage) {
        this.staffConnectStorage = staffConnectStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataLoadingException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ StaffConnect methods ==============================

    @Override
    public Path getAddressBookFilePath() {
        return staffConnectStorage.getAddressBookFilePath();
    }

    @Override
    public Optional<ReadOnlyStaffConnect> readAddressBook() throws DataLoadingException {
        return readAddressBook(staffConnectStorage.getAddressBookFilePath());
    }

    @Override
    public Optional<ReadOnlyStaffConnect> readAddressBook(Path filePath) throws DataLoadingException {
        logger.fine("Attempting to read data from file: " + filePath);
        return staffConnectStorage.readAddressBook(filePath);
    }

    @Override
    public void saveAddressBook(ReadOnlyStaffConnect addressBook) throws IOException {
        saveAddressBook(addressBook, staffConnectStorage.getAddressBookFilePath());
    }

    @Override
    public void saveAddressBook(ReadOnlyStaffConnect addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        staffConnectStorage.saveAddressBook(addressBook, filePath);
    }

}
