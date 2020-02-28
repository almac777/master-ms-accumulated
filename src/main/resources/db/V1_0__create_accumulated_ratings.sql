create table accumulated_ratings
(
    id                 bigint not null auto_increment,
    article_id         bigint not null,
    completion_rating  float,
    objectivity_rating float,
    amount             bigint,
    primary key (id)
);

ALTER TABLE accumulated_ratings
    ADD CONSTRAINT unique_accumulated_rating_per_article
        UNIQUE (article_id);
