-- Table: public.catalogue

-- DROP TABLE public.catalogue;

CREATE TABLE public.catalogue
(
  fid integer NOT NULL,
  aid integer NOT NULL,
  prix numeric(8,2),
  CONSTRAINT catalogue_fid_fkey FOREIGN KEY (fid)
      REFERENCES public.fournisseurs (fid) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.catalogue
  OWNER TO dbuser;
