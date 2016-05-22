CREATE DATABASE inaction
WITH OWNER = postgres
ENCODING = 'UTF8';

CREATE TABLE public.users
(
  id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),
  email text NOT NULL,
  password text NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.users
  OWNER TO postgres;

