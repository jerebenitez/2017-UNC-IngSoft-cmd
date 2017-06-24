select Aula, Capacidad, Proyector, concat(hora_inicio,'-' ,hora_fin) as Modulo
from (select numero as Aula, capacidad as Capacidad, proyector as Proyector, idmodulo from aula a join reserva r
where a.idaula != r.idaula) libres 
join modulo m where m.idmodulo = libres.idmodulo;
