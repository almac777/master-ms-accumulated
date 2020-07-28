create table accumulated_ratings
(
    id                 bigint not null generated always as identity primary key,
    article_id         bigint not null,
    completion_rating  float,
    objectivity_rating float,
    amount             bigint
);

ALTER TABLE accumulated_ratings
    ADD CONSTRAINT unique_accumulated_rating_per_article
        UNIQUE (article_id);
