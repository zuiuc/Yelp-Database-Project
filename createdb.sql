
CREATE TABLE YELP_BUSINESS(
business_id         VARCHAR2(50) PRIMARY KEY,
full_address        VARCHAR2(200),
categories	VARCHAR2(500),
city            VARCHAR2(50),
reviews_count	int，
full_name       VARCHAR2(300),
state       VARCHAR2(5),
stars           VARCHAR2(100),
type          VARCHAR2(50)
);

CREATE TABLE YELP_USER(
yelping_since   VARCHAR2(50),
review_count     int,
user_name           VARCHAR2(300),
user_id         VARCHAR2(50) PRIMARY KEY,
friends          int,
average_stars           VARCHAR2(100)
);

CREATE TABLE YELP_CHECKIN(
checkin_info      VARCHAR2(2000),
business_id         VARCHAR2(50) REFERENCES YELP_BUSINESS(business_id) ON DELETE CASCADE
);

CREATE TABLE YELP_REVIEW(
votes           int,
user_id         VARCHAR2(50) REFERENCES YELP_USER(user_id) ON DELETE CASCADE ,
review_id         VARCHAR2(50) PRIMARY KEY,
stars           VARCHAR2(100),
create_date     VARCHAR2(50),
business_id         VARCHAR2(50) REFERENCES YELP_BUSINESS(business_id) ON DELETE CASCADE
);
