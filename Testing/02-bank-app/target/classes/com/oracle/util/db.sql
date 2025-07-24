-- ACCOUNT TABLE
CREATE TABLE account (
    id NUMBER PRIMARY KEY,
    account_number VARCHAR2(50) NOT NULL,
    balance NUMBER(15,2)
);

-- CUSTOMER TABLE
CREATE TABLE customer (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    email VARCHAR2(100),
    account_id NUMBER NOT NULL,
    CONSTRAINT fk_account FOREIGN KEY (account_id) REFERENCES account(id)
);
