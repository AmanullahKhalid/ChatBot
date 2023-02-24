--liquibase formatted sql

--changeset Amanullah:1
CREATE TABLE message (
    id bigserial not null,
    body varchar(255) not null,
    odr int4 not null,
    responses varchar(255) default null,
    choice varchar(10) default null,
    primary key (id)
)

--changeset Amanullah:2
INSERT
INTO
  message
  (body, odr, responses)
VALUES
  ('Hi! This is LISA. I have a great shift opportunity for you! Are you Interested in hearing about it? Please respond Yes or No', 0, 'YES;NO');


INSERT
INTO
  message
  (body, odr, choice)
VALUES
  ('Great the shift is at 1313 Mockingbird Ln at 2/15/2021 4:00pm-12:00am. We will see you there!', 1, 'YES');


INSERT
INTO
  message
  (body, odr, responses, choice)
VALUES
  ('Ok, thanks. Can you let me know why not? Respond 1: Too far Respond 2: Not available Respond 3: Other', 1, '1;2;3', 'NO');


INSERT
INTO
  message
  (body, odr, choice)
VALUES
  ('Thanks for letting me know. I will avoid offering shifts at this location in the future.', 2, '1');

INSERT
INTO
  message
  (body, odr, choice)
VALUES
  ('Thanks for letting me know. I will avoid offering shifts at this location in the future.', 2, '2');

INSERT
INTO
  message
  (body, odr, choice)
VALUES
  ('Ok. Thanks. I would not offer shifts at this location or time in the future.', 2, '3');
