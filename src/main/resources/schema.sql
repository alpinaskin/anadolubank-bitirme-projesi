CREATE TABLE IF NOT EXISTS accounts (
                        id         INTEGER  NOT NULL PRIMARY KEY,
                        first_name VARCHAR(10) NOT NULL,
                        last_name  VARCHAR(15) NOT NULL,
                        birthday   DATE  NOT NULL,
                        gender     VARCHAR(11) NOT NULL,
                        city       INTEGER  NOT NULL
);

CREATE TABLE IF NOT EXISTS agencies (
                        id   INTEGER  NOT NULL PRIMARY KEY,
                        name VARCHAR(37) NOT NULL
);

CREATE TABLE IF NOT EXISTS policies (
                       id             INTEGER  NOT NULL PRIMARY KEY,
                       start_date     DATE  NOT NULL,
                       end_date       DATE  NOT NULL,
                       no             INTEGER  NOT NULL,
                       account_id     VARCHAR(30),
                       type           VARCHAR(8) NOT NULL,
                       tc             INTEGER  NOT NULL,
                       comission_rate NUMERIC(4,1) NOT NULL,
                       agency_id      INTEGER  NOT NULL
);

CREATE TABLE IF NOT EXISTS policy_options (
                      id        INTEGER  NOT NULL PRIMARY KEY,
                      net       NUMERIC(7,2) NOT NULL,
                      gross     NUMERIC(7,2) NOT NULL,
                      policy_id INTEGER  NOT NULL
);
