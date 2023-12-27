# REST API

REST API тестового ПО «Каталог продуктов» 

## Логин, получение токена

### Request

`POST /api/v1/auth/login`

{"login": "admin", "password": "admin"} 

### Response

{
    "access_token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBnbWF...",
    "token_type": "Bearer"
}

## Добавить пользователя

### Request

`POST /api/v1/auth/register`

### Response

{
    "user_name": "testUser",
    "email": "testUser@gmail",
    "password": "testUser"
}

## Получение списка категорий

### Request

`POST /api/v1/categories`
Authorization: Bearer access_token 

{
  "category_name": "Вода",
}  

### Response

[{"category_id":3,"category_name":"Вода","products":[{"product_id":4,"product_name":"Квас","category_id":3,"category_name":"Вода","description":"В бутылках","cost":15.0,"notes":"Вятский","special_notes":"Теплый"}]}]


## Получение категории по id

### Request

`GET /api/v1/categories/{id}`
Authorization: Bearer access_token 

### Response

{"category_id":3,"category_name":"Вода","products":[{"product_id":4,"product_name":"Квас","category_id":3,"category_name":"Вода","description":"В бутылках","cost":15.0,"notes":"Вятский","special_notes":"Теплый"}]}

## Создание категории

### Request

`POST /api/v1/categories/add`
Authorization: Bearer access_token 

{
  "category_name":"Снэки"
}

### Response

{"category_id":4,"category_name":"Снэки","products":null}

## Обновление категории

### Request

`PUT /api/v1/categories/update/{id}`
Authorization: Bearer access_token 

{
  "category_id": 4,
  "category_name": "Снэки соленые"
}

### Response

{"category_id":4,"category_name":"Снэки соленые","products":null}


## Удаление категории

### Request

`DELETE /api/v1/categories/delete/{id}`
Authorization: Bearer access_token 

### Response

200 OK


## Получение списка продуктов

### Request

`POST /api/v1/products`
Authorization: Bearer access_token 

{
  "product_name": "Селедка",
}  

### Response

[
  {
    "product_id": 1,
    "product_name": "Селедка",
    "category_id": 1,
    "category_name": "Еда",
    "description": "Селедка соленая",
    "cost": 10.0,
    "notes": "Акция",
    "special_notes": "Пересоленная"
  }
]

## Получение продукта по id

### Request

`GET /api/v1/products/{id}`
Authorization: Bearer access_token 

### Response

{
  "product_id": 1,
  "product_name": "Селедка",
  "category_id": 1,
  "category_name": "Еда",
  "description": "Селедка соленая",
  "cost": 10.0,
  "notes": "Акция",
  "special_notes": "Пересоленная"
}

## Создание продукта

### Request

`POST /api/v1/products/add`
Authorization: Bearer access_token 

{
  "product_name": "Крекер",
  "category_id": 5,
  "description": "Крекер соленый",
  "cost": 3.0,
  "notes": "Крохкий",
  "special_notes": "Сухой"
}

### Response

{
  "product_id": 5,
  "product_name": "Крекер",
  "category_id": 5,
  "category_name": "Снэки",
  "description": "Крекер соленый",
  "cost": 3.0,
  "notes": "Крохкий",
  "special_notes": "Сухой"
}

## Обновление продукта

### Request

`PUT /api/v1/products/update/{id}`
Authorization: Bearer access_token 

{
  "product_id": 5,
  "product_name": "Крекер",
  "category_id": 5,
  "category_name": "Снэки",
  "description": "Крекер соленый",
  "cost": 3.0,
  "notes": "Крохкий и дорогой",
  "special_notes": "Сухой"
}

### Response

{
  "product_id": 5,
  "product_name": "Крекер",
  "category_id": 5,
  "category_name": "Снэки",
  "description": "Крекер соленый",
  "cost": 3.0,
  "notes": "Крохкий и дорогой",
  "special_notes": "Сухой"
}


## Удаление продукта

### Request

`DELETE /api/v1/products/delete/{id}`
Authorization: Bearer access_token 

### Response

200 OK
