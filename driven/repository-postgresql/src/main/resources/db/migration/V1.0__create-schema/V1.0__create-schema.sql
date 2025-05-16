CREATE TABLE IF NOT EXISTS contacts (
	"name" varchar(100) NOT NULL,
	phone_number varchar(30),
	CONSTRAINT contacts_pk PRIMARY KEY (phone_number)
);
COMMENT ON COLUMN contacts."name" IS 'Nombre del contacto, ej: Juan';
COMMENT ON COLUMN contacts.phone_number IS 'Número de teléfono del contacto, +34 666 666 666';