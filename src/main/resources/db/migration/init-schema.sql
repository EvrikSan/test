CREATE table PositionType (
	id bigint PRIMARY KEY,
	job_name varchar(150) NOT NULL
);

CREATE table Shops (
	id bigint PRIMARY KEY,
	name varchar(250) NOT NULL,
	adress text
);

CREATE table ElectroType (
	id bigint PRIMARY KEY,
	name varchar(150)
);

CREATE table PurchaseType (
	id bigint PRIMARY KEY,
	name varchar(150)
);

CREATE table ElectroItem (
	id bigint PRIMARY KEY,
	name varchar(150),
	eTypeId bigint,
	price bigint,
	count int,
	archive boolean,
	description text,
	CONSTRAINT fk_ElectroItem_eTypeId_ElectroType
		FOREIGN KEY (eTypeId)
		REFERENCES ElectroType(id)
);

CREATE table Employee (
	id bigint PRIMARY KEY,
	lastName varchar(100) NOT NULL,
	firstName varchar(100) NOT NULL,
	patronymic varchar(100),
	birthDate date NOT NULL,
	positionId bigint,
	shopId bigint,
	gender boolean NOT NULL,
	CONSTRAINT fk_Employee_positionId_PositionType
		FOREIGN KEY (positionId)
		REFERENCES PositionType (id),
	CONSTRAINT fk_Employee_shopId_Shops
		FOREIGN KEY (shopId)
		REFERENCES Shops(id)
);

CREATE table Purchase (
	id bigint PRIMARY KEY,
	electroId bigint,
	employeeId bigint,
	shopId bigint,
	purchaseDate timestamp,
	typeId bigint,
	CONSTRAINT fk_Purchase_electroId_ElectroItem
		FOREIGN KEY (electroId)
		REFERENCES ElectroItem (id),
	CONSTRAINT fk_Purchase_employeeId_Epmloyee
		FOREIGN KEY (employeeId)
		REFERENCES Employee (id),
	CONSTRAINT fk_Purchase_shopId_Shops
		FOREIGN KEY (shopId)
		REFERENCES Shops (id),
	CONSTRAINT fk_Purchase_typeID_PurchaseType
		FOREIGN KEY (typeID)
		REFERENCES PurchaseType (id)
);

CREATE table ElectroEmployee (
	employeeId bigint NOT NULL,
	electroTypeId bigint NOT NULL,
	PRIMARY KEY (employeeId, electroTypeId),
	CONSTRAINT ElectroEmployee_employeeId_Employee
		FOREIGN KEY (employeeId)
		REFERENCES Employee,
	CONSTRAINT ElectroEmployee_electroTypeId_ElectroType
		FOREIGN KEY (electroTypeId)
		REFERENCES ElectroType
);

CREATE table ElectroShop (
	shopId bigint NOT NULL,
	electroItemId bigint NOT NULL,
	count int,
	PRIMARY KEY (shopId, electroItemId),
	CONSTRAINT ElectroShop_shopId_Shops
		FOREIGN KEY (shopId)
		REFERENCES Shops,
	CONSTRAINT ElectroShop_electroItemId_ElectroItem
		FOREIGN KEY (electroItemId)
		REFERENCES ElectroItem
);


