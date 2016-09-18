package JMP.training.services;


public enum PersonSQLQueriesEnum {

    GET_ALL_PERSON {
        @Override
        public String getQuery() {
            return "SELECT * FROM person";
        }
    },
    SAVE_PERSON {
        @Override
        public String getQuery() {
            return " INSERT INTO person (name,age) VALUES (?,?)";
        }
    },
    GET_PERSON_BY_NAME {
        @Override
        public String getQuery() {
            return "SELECT * FROM person WHERE NAME = ?";
        }
    },
    UPDATE_PERSON_BY_NAME {
        @Override
        public String getQuery() {
            return "UPDATE person  SET  AGE = ? WHERE NAME=?";
        }
    };

    public abstract String getQuery ();
}