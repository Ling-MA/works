-- Table: public.fournisseurs

-- DROP TABLE public.fournisseurs;

CREATE TABLE public.fournisseurs
(
  fid integer NOT NULL,
  fnom character varying(255),
  fad character varying(255),
  CONSTRAINT fournisseurs_pkey PRIMARY KEY (fid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.fournisseurs
  OWNER TO dbuser;
