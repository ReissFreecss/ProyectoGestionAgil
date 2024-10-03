BEGIN TRANSACTION;
DROP TABLE IF EXISTS "Pacientes";
CREATE TABLE IF NOT EXISTS "Pacientes" (
	"id_paciente"	INTEGER,
	"nombre_completo"	TEXT,
	"edad"	INTEGER,
	"sexo"	TEXT,
	"ocupacion"	TEXT,
	"motivo_consulta"	TEXT,
	"fecha_consulta"	DATE,
	"telefono"	TEXT,
	PRIMARY KEY("id_paciente" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Antecedentes_Medicos";
CREATE TABLE IF NOT EXISTS "Antecedentes_Medicos" (
	"id_antecedente"	INTEGER,
	"id_paciente"	INTEGER,
	"enfermedad_diagnosticada"	TEXT NOT NULL DEFAULT 'Ninguna',
	"medicamentos"	TEXT NOT NULL DEFAULT 'Ninguna',
	"inicio_medicacion"	DATE DEFAULT NULL,
	"ultima_desparasitacion"	DATE DEFAULT NULL,
	"ultima_realizacion_laboratorios"	DATE DEFAULT NULL,
	"alergia_intolerancia_alimentos"	TEXT,
	FOREIGN KEY("id_paciente") REFERENCES "Pacientes"("id_paciente") ON DELETE CASCADE,
	PRIMARY KEY("id_antecedente" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Antecedentes_Familiares";
CREATE TABLE IF NOT EXISTS "Antecedentes_Familiares" (
	"id_antecedente_familiar"	INTEGER,
	"id_paciente"	INTEGER,
	"parentezco"	TEXT NOT NULL DEFAULT 'Ninguna',
	"enfermedad_diagnosticada"	TEXT NOT NULL DEFAULT 'Ninguna',
	"alergias_medicamentos"	TEXT NOT NULL DEFAULT 'Ninguna',
	FOREIGN KEY("id_paciente") REFERENCES "Pacientes"("id_paciente") ON DELETE CASCADE,
	PRIMARY KEY("id_antecedente_familiar" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Datos_Ginecologicos";
CREATE TABLE IF NOT EXISTS "Datos_Ginecologicos" (
	"id_ginecologico"	INTEGER,
	"id_paciente"	INTEGER,
	"embarazo_actual"	TEXT NOT NULL DEFAULT 'NO',
	"sdg"	TEXT NOT NULL DEFAULT 'Ninguna',
	"referido_por_paciente"	TEXT NOT NULL DEFAULT 'Ninguno',
	"fum"	DATE DEFAULT NULL,
	"anticonceptivos_orales"	TEXT NOT NULL DEFAULT 'NO',
	"cual_anticonceptivo"	TEXT NOT NULL DEFAULT 'Ninguno',
	"dosis_anticonceptivo"	TEXT NOT NULL DEFAULT 'Ninguna',
	"num_embarazos"	INTEGER NOT NULL DEFAULT 0,
	FOREIGN KEY("id_paciente") REFERENCES "Pacientes"("id_paciente") ON DELETE CASCADE,
	PRIMARY KEY("id_ginecologico" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Estilo_Vida";
CREATE TABLE IF NOT EXISTS "Estilo_Vida" (
	"id_estilo_vida"	INTEGER,
	"id_paciente"	INTEGER,
	"hora_despertar"	TEXT DEFAULT 'Ninguno',
	"hora_dormir"	TEXT DEFAULT 'Ninguno',
	"hora_trabajo_estudio"	TEXT DEFAULT 'Ninguno',
	"hora_entrenamiento"	TEXT DEFAULT 'Ninguno',
	"tipo_ejercicio"	TEXT DEFAULT 'Ninguno',
	"intensidad"	TEXT DEFAULT 'Ninguno',
	"frecuencia_ejercicio"	INTEGER DEFAULT NULL,
	FOREIGN KEY("id_paciente") REFERENCES "Pacientes"("id_paciente") ON DELETE CASCADE,
	PRIMARY KEY("id_estilo_vida" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Consumo_Sustancias";
CREATE TABLE IF NOT EXISTS "Consumo_Sustancias" (
	"id_consumo_sustancia"	INTEGER,
	"id_paciente"	INTEGER,
	"sustancia"	TEXT DEFAULT 'Ninguno',
	"tipo"	TEXT DEFAULT 'Ninguno',
	"frecuencia"	INTEGER DEFAULT 0,
	"cantidad"	TEXT DEFAULT 'Ninguno',
	FOREIGN KEY("id_paciente") REFERENCES "Pacientes"("id_paciente") ON DELETE CASCADE,
	PRIMARY KEY("id_consumo_sustancia" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Comidas";
CREATE TABLE IF NOT EXISTS "Comidas" (
	"id_comidas"	INTEGER,
	"id_paciente"	INTEGER,
	"comida"	TEXT DEFAULT 'Ninguna',
	"horario"	TEXT,
	"platillo"	TEXT,
	"ingredientes"	TEXT,
	"cantidad"	TEXT,
	"come_calle"	TEXT DEFAULT 'NO',
	"frecuencia_comida_calle"	INTEGER DEFAULT 0,
	FOREIGN KEY("id_paciente") REFERENCES "Pacientes"("id_paciente") ON DELETE CASCADE,
	PRIMARY KEY("id_comidas" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Indicadores_Dieteticos";
CREATE TABLE IF NOT EXISTS "Indicadores_Dieteticos" (
	"id_indicadores_dieteticos"	INTEGER,
	"id_paciente"	INTEGER,
	"preparador_alimentos"	TEXT,
	"hora_apetito"	TEXT,
	"alimentos_preferidos"	TEXT,
	"alimentos_no_preferidos"	TEXT,
	"suplemento"	TEXT,
	"dosis_suplemento"	TEXT,
	"agua_consumida"	DECIMAL(5, 2),
	"refresco_consumido"	DECIMAL(5, 2),
	"leche_consumida"	DECIMAL(5, 2),
	"medicamentos_bajar_peso"	TEXT,
	FOREIGN KEY("id_paciente") REFERENCES "Pacientes"("id_paciente") ON DELETE CASCADE,
	PRIMARY KEY("id_indicadores_dieteticos" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Dieta_Especial";
CREATE TABLE IF NOT EXISTS "Dieta_Especial" (
	"id_dieta_especial"	INTEGER,
	"id_paciente"	INTEGER,
	"dieta_especial"	TEXT DEFAULT 'NO',
	"tipo_dieta"	TEXT,
	"tiempo_dieta_especial"	TEXT,
	"razon_dieta_especial"	TEXT,
	"resultado_dieta_especial"	TEXT,
	"apego_dieta"	TEXT,
	FOREIGN KEY("id_paciente") REFERENCES "Pacientes"("id_paciente") ON DELETE CASCADE,
	PRIMARY KEY("id_dieta_especial" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Indicadores_Antropometricos";
CREATE TABLE IF NOT EXISTS "Indicadores_Antropometricos" (
	"id_indicador"	INTEGER,
	"id_paciente"	INTEGER,
	"fecha"	DATE DEFAULT NULL,
	"peso"	DECIMAL(5, 2),
	"estatura"	DECIMAL(5, 2),
	"circunferencia_brazo"	DECIMAL(5, 2),
	"circunferencia_cintura"	DECIMAL(5, 2),
	"circunferencia_cadera"	DECIMAL(5, 2),
	"circunferencia_muslo"	DECIMAL(5, 2),
	FOREIGN KEY("id_paciente") REFERENCES "Pacientes"("id_paciente") ON DELETE CASCADE,
	PRIMARY KEY("id_indicador" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Datos_Interpretacion";
CREATE TABLE IF NOT EXISTS "Datos_Interpretacion" (
	"id_datos_interpretacion"	INTEGER,
	"id_paciente"	INTEGER,
	"fecha"	DATE DEFAULT NULL,
	"peso"	DECIMAL(5, 2),
	"porcentaje_grasa_corporal"	DECIMAL(5, 2),
	"masa_muscular"	DECIMAL(5, 2),
	"masa_osea"	DECIMAL(5, 2),
	"imc"	DECIMAL(5, 2),
	"ingesta_kilocalorias"	DECIMAL(6, 2),
	"edad_metabolica"	INTEGER,
	"porcentaje_agua_corporal"	DECIMAL(5, 2),
	"grasa_visceral"	DECIMAL(5, 2),
	"pliegue_tricipital"	DECIMAL(5, 2),
	"pliegue_bicipital"	DECIMAL(5, 2),
	"pliegue_suprailiaco"	DECIMAL(5, 2),
	"pliegue_subescapular"	DECIMAL(5, 2),
	FOREIGN KEY("id_paciente") REFERENCES "Pacientes"("id_paciente") ON DELETE CASCADE,
	PRIMARY KEY("id_datos_interpretacion" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Dietas";
CREATE TABLE IF NOT EXISTS "Dietas" (
	"id_dieta"	INTEGER,
	"id_paciente"	INTEGER,
	"comida"	TEXT,
	"horario"	TEXT,
	"porciones"	TEXT,
	"ingredientes"	TEXT,
	"suplemento"	TEXT,
	"dosis_suplemento"	TEXT,
	FOREIGN KEY("id_paciente") REFERENCES "Pacientes"("id_paciente") ON DELETE CASCADE,
	PRIMARY KEY("id_dieta" AUTOINCREMENT)
);
COMMIT;
