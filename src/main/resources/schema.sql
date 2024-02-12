CREATE TABLE IF NOT EXISTS products (
    title varchar(256) NOT NULL,
    article varchar(500) NOT NULL PRIMARY KEY,
    description text NOT NULL,
    cost float,
    imageURL varchar(256));

insert into products (title, article, description, cost, imageURL)
VALUES
    ('Nowy premier Słowacji', '1',
    'Nowy premier Słowacji Robert Fico idzie śladem premiera Węgier Viktora Orbana.
    W wywiadzie dla słowackiego radia publicznego, stwierdził,
    że Ukraina będzie musiała oddać część terytorium.',
    10000, '/img/no-photo.jgp');

