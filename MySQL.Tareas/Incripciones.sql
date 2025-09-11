SELECT * FROM incripciones_cursos.cursos;

CREATE DATABASE IF NOT EXISTS incripciones_cursos;
USE incripciones_cursos;

INSERT INTO estudiantes (nombre, edad) VALUES
    ('Juan Perez', 20),
    ('Maria Gomez', 22),
    ('Carlos Lopez', 19),
    ('Ana Martinez', 21),
    ('Luis Fernandez', 23);


INSERT INTO cursos (nombre, duracion) VALUES
    ('Matematicas', '2026-11-10'), 
    ('Programacion', '2026-11-30'), 
    ('Historia', '2026-10-31'),   
    ('Fisica', '2026-11-20');


INSERT INTO inscripciones (Estudiantes_id_estudiante, Cursos_id_cursos) VALUES
    (1, 1), 
    (1, 2), 
    (2, 2), 
    (2, 3), 
    (3, 1), 
    (3, 3), 
    (4, 2), 
    (4, 4); 
    
SELECT e.nombre AS estudiante, c.nombre AS curso, c.duracion
FROM estudiantes e
LEFT JOIN inscripciones i ON e.id_estudiante = i.estudiantes_id_estudiante
LEFT JOIN cursos c ON i.cursos_id_cursos = c.id_cursos
ORDER BY e.nombre, c.nombre;

SELECT e.nombre AS estudiante, c.nombre AS curso
FROM estudiantes e
INNER JOIN inscripciones i ON e.id_estudiante = i.estudiantes_id_estudiante
INNER JOIN cursos c ON i.cursos_id_cursos = c.id_cursos
WHERE c.nombre = 'Matematicas'
ORDER BY e.nombre;

SELECT e.nombre AS estudiante, c.nombre AS curso
FROM estudiantes e
INNER JOIN inscripciones i ON e.id_estudiante = i.estudiantes_id_estudiante
INNER JOIN cursos c ON i.cursos_id_cursos = c.id_cursos
WHERE c.nombre = 'Programacion'
ORDER BY e.nombre;

SELECT e.nombre AS estudiante, c.nombre AS curso
FROM estudiantes e
INNER JOIN inscripciones i ON e.id_estudiante = i.estudiantes_id_estudiante
INNER JOIN cursos c ON i.cursos_id_cursos = c.id_cursos
WHERE c.nombre = 'Historia'
ORDER BY e.nombre;

SELECT e.nombre AS estudiante, c.nombre AS curso
FROM estudiantes e
INNER JOIN inscripciones i ON e.id_estudiante = i.estudiantes_id_estudiante
INNER JOIN cursos c ON i.cursos_id_cursos = c.id_cursos
WHERE c.nombre = 'Fisica'
ORDER BY e.nombre;

SELECT e.nombre AS estudiante, c.nombre AS curso, c.duracion
FROM estudiantes e
INNER JOIN inscripciones i ON e.id_estudiante = i.estudiantes_id_estudiante
INNER JOIN cursos c ON i.cursos_id_cursos = c.id_cursos
WHERE e.nombre = 'Ana Martinez'
ORDER BY c.nombre;

SELECT c.nombre AS curso, COUNT(i.estudiantes_id_estudiante) AS numero_estudiantes
FROM cursos c
LEFT JOIN inscripciones i ON c.id_cursos = i.cursos_id_cursos
GROUP BY c.id_cursos, c.nombre
ORDER BY numero_estudiantes DESC, c.nombre;

SELECT e.id_estudiante, e.nombre AS estudiante, e.edad
FROM estudiantes e
LEFT JOIN inscripciones i ON e.id_estudiante = i.estudiantes_id_estudiante
WHERE i.estudiantes_id_estudiante IS NULL
ORDER BY e.nombre;


