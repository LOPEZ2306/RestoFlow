# 🍽️ RestoFlow

Sistema de gestión de restaurante con **arquitectura hexagonal** (Ports & Adapters).  
Backend: **Spring Boot 3** · Base de datos: **PostgreSQL** · Frontend: **React + Vite**

---

## 📁 Estructura del proyecto

```
restoflow/
├── backend/          # API REST — Spring Boot 3 + Java 21
│   ├── src/
│   │   ├── main/java/com/restoflow/
│   │   │   ├── domain/           # Fase 1: Dominio puro (VOs, entidades, excepciones)
│   │   │   │   ├── exception/
│   │   │   │   ├── model/
│   │   │   │   └── vo/
│   │   │   └── RestoflowApplication.java
│   │   └── test/java/com/restoflow/
│   │       └── domain/model/     # Tests unitarios del dominio
│   └── pom.xml
├── frontend/         # SPA — React + Vite (próximamente)
├── docker-compose.yml
└── .gitignore
```

## 🚀 Requisitos previos

| Herramienta | Versión mínima |
|-------------|---------------|
| Java (JDK)  | 21            |
| Maven       | Wrapper incluido (`./mvnw`) |
| Docker Desktop | 24+        |
| Node.js     | 20+           |

## ⚙️ Levantar el entorno

### 1. Base de datos (Docker)
```bash
docker compose up -d   # Levanta PostgreSQL en localhost:5432
```

### 2. Backend
```bash
cd backend
.\mvnw.cmd spring-boot:run          # Levanta la API en http://localhost:8080
```

### 3. Tests unitarios
```bash
cd backend
.\mvnw.cmd test
```

### 4. Frontend (próximamente)
```bash
cd frontend
npm install
npm run dev   # http://localhost:5173
```

## 📐 Arquitectura

El proyecto sigue la **Arquitectura Hexagonal** (Ports & Adapters):

```
Domain (núcleo puro)
  └── Ports (interfaces)
        └── Adapters (infraestructura: JPA, REST, WebSocket)
```

La capa de dominio **no depende de Spring ni de JPA**; contiene únicamente la lógica de negocio.

## 🗺️ Roadmap de fases

| Fase | Contenido | Estado |
|------|-----------|--------|
| 0 | Scaffolding + Docker Compose + pom.xml | ✅ Completo |
| 1 | Dominio puro (entidades, VOs, excepciones) | ✅ Completo |
| 2 | Puertos (contratos de repositorio y servicios) | 🔜 |
| 3 | Casos de uso (servicios de aplicación) | 🔜 |
| 4 | Adaptadores JPA (repositorios PostgreSQL) | 🔜 |
| 5 | API REST (controladores) | 🔜 |
| 6 | Seguridad JWT | 🔜 |
| 7 | WebSockets (tiempo real) | 🔜 |
| 8 | Frontend React | 🔜 |
| 9 | CI/CD | 🔜 |

## 👤 Autor

**Juan Manuel López** — [LOPEZ2306](https://github.com/LOPEZ2306)
