public final class PersonnageContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedPerso implements BaseColumns {
        public static final String TABLE_NAME = "perso";
        public static final String COLUMN_NAME_LEVEL = "level";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_SUCCESS = "success";
        public static final String COLUMN_NAME_KOLIZEUM = "kolizeum";
        public static final String COLUMN_NAME_GUILDE = "guilde";
        public static final String COLUMN_NAME_ALLIANCE = "alliance";
        public static final String COLUMN_NAME_SERVER = "server
		
		
        // public static final String COLUMN_NAME_ = "level";
        // public static final String COLUMN_NAME_NAME = "name";
        // public static final String COLUMN_NAME_LEVEL = "level";
        // public static final String COLUMN_NAME_NAME = "name";
    }
}