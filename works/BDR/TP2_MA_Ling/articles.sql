-- Table: public.articles

-- DROP TABLE public.articles;

CREATE TABLE public.articles
(
  aid integer NOT NULL,
  anom character varying(255),
  acoul character varying(255),
  CONSTRAINT articles_pkey PRIMARY KEY (aid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.articles
  OWNER TO dbuser;
