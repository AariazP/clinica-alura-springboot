ALTER TABLE medicos ADD COLUMN activo BOOLEAN;
UPDATE medicos SET activo = true;
ALTER TABLE medicos ALTER COLUMN activo SET DEFAULT true;