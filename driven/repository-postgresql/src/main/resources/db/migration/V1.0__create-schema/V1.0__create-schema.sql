CREATE SEQUENCE IF NOT EXISTS CONTACTS_SEQ
START WITH 1
INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS contacts (
    id BIGINT NOT NULL DEFAULT nextval('CONTACTS_SEQ'),
	"name" VARCHAR(100) NOT NULL,
	phone_number VARCHAR(30),
	CONSTRAINT contacts_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN contacts.id IS 'Identificador del contacto, ej: 1';
COMMENT ON COLUMN contacts."name" IS 'Nombre del contacto, ej: Juan';
COMMENT ON COLUMN contacts.phone_number IS 'Número de teléfono del contacto, +34 666 666 666';