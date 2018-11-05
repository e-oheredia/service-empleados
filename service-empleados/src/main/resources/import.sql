insert into tipo_sede(nombre) values('SUCURSAL AGENCIAS LIMA');
insert into sede(nombre, codigo, tipo_sede_id, direccion, distrito_id) values('LIMA AGENCIAS', 'LAG', 1, 'Jr. Huancavelica', 1);
insert into area(nombre, codigo, sede_id) values('COMERCIAL','C001',1);
insert into area(nombre, codigo, sede_id) values('PROYECTOS','C002',1);
insert into area(nombre, codigo, sede_id) values('CONTABILIDAD','C003',1);
insert into area(nombre, codigo, sede_id) values('COBRANZAS','C004',1);
insert into area(nombre, codigo, sede_id) values('TARJETAS DÉBITO','C005',1);
insert into area(nombre, codigo, sede_id) values('TARJETAS CRÉDITO','C006',1);
insert into area(nombre, codigo, sede_id) values('ADMINISTRACIÓN','C007',1);
insert into area(nombre, codigo, sede_id) values('OPERACIONES','C008',1);
insert into tipo_puesto(nombre) values('JEFE');
insert into puesto(nombre, tipo_puesto_id, area_id) values('JEFE COMERCIAL', 1, 1);
insert into puesto(nombre, tipo_puesto_id, area_id) values('JEFE PROYECTOS', 1, 2);
insert into puesto(nombre, tipo_puesto_id, area_id) values('JEFE CONTABILIDAD', 1, 3);
insert into puesto(nombre, tipo_puesto_id, area_id) values('JEFE COBRANZAS', 1, 4);
insert into puesto(nombre, tipo_puesto_id, area_id) values('JEFE TARJETAS DÉBITO', 1, 5);
insert into puesto(nombre, tipo_puesto_id, area_id) values('JEFE TARJETAS CRÉDITO', 1, 6);
insert into puesto(nombre, tipo_puesto_id, area_id) values('JEFE ADMINISTRACIÓN', 1, 7);
insert into puesto(nombre, tipo_puesto_id, area_id) values('JEFE OPERACIONES', 1, 8);
insert into empleado(matricula, nombres) values('OHEREDIA', 'ORLANDO HEREDIA');
insert into empleado(matricula, nombres) values('CCAMPOS', 'CHRISTIAN CAMPOS');
insert into empleado(matricula, nombres) values('RSANTOS', 'RONALD SANTOS');
insert into empleado(matricula, nombres) values('CBALTAZAR', 'CESAR BALTAZAR');
insert into empleado(matricula, nombres) values('KVEGA', 'KATHERINE VEGA');
insert into empleado(matricula, nombres) values('KMACEDO', 'KATHELEEN MACEDO');
insert into empleado(matricula, nombres) values('KARRUE', 'KRYSTEL ARRUE');
insert into empleado(matricula, nombres) values('MCEVALLOS', 'MEDALIT CEVALLOS');
insert into puesto_empleado(puesto_id, empleado_id, fecha_asociado) values(1, 1, GETDATE());
insert into puesto_empleado(puesto_id, empleado_id, fecha_asociado) values(2, 2, GETDATE());
insert into puesto_empleado(puesto_id, empleado_id, fecha_asociado) values(3, 3, GETDATE());
insert into puesto_empleado(puesto_id, empleado_id, fecha_asociado) values(4, 4, GETDATE());
insert into puesto_empleado(puesto_id, empleado_id, fecha_asociado) values(5, 5, GETDATE());
insert into puesto_empleado(puesto_id, empleado_id, fecha_asociado) values(6, 6, GETDATE());
insert into puesto_empleado(puesto_id, empleado_id, fecha_asociado) values(7, 7, GETDATE());
insert into puesto_empleado(puesto_id, empleado_id, fecha_asociado) values(8, 8, GETDATE());
insert into buzon(nombre, area_id, activo) values('ORLANDO HEREDIA', 1, 1);
insert into buzon(nombre, area_id, activo) values('CHRISTIAN CAMPOS', 2, 1);
insert into buzon(nombre, area_id, activo) values('RONALD SANTOS', 3, 1);
insert into buzon(nombre, area_id, activo) values('CESAR BALTAZAR', 4, 1);
insert into buzon(nombre, area_id, activo) values('KATHERINE VEGA', 5, 1);
insert into buzon(nombre, area_id, activo) values('KATHELEEN MACEDO', 6, 1);
insert into buzon(nombre, area_id, activo) values('KRYSTEL ARRUE', 7, 1);
insert into buzon(nombre, area_id, activo) values('MEDALIT CEVALLOS', 8, 1);
insert into buzon_empleado(buzon_id, empleado_id, fecha_asociado) values(1,1,GETDATE());
insert into buzon_empleado(buzon_id, empleado_id, fecha_asociado) values(2,2,GETDATE());
insert into buzon_empleado(buzon_id, empleado_id, fecha_asociado) values(3,3,GETDATE());
insert into buzon_empleado(buzon_id, empleado_id, fecha_asociado) values(4,4,GETDATE());
insert into buzon_empleado(buzon_id, empleado_id, fecha_asociado) values(5,5,GETDATE());
insert into buzon_empleado(buzon_id, empleado_id, fecha_asociado) values(6,6,GETDATE());
insert into buzon_empleado(buzon_id, empleado_id, fecha_asociado) values(7,7,GETDATE());
insert into buzon_empleado(buzon_id, empleado_id, fecha_asociado) values(8,8,GETDATE());
insert into sede(nombre, codigo, tipo_sede_id, direccion, distrito_id) values('LIMA AGENCIAS 2', 'LAG2', 1, 'Jr. Huancavelica', 2);