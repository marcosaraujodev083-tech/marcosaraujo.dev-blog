
<div align="center">

--- 

### Marcos Araújo

*Engenheiro de Software & Desenvolvedor Full-Stack*

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/marcos-araujo-517201212/)
[![WhatsApp](https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white)](https://wa.me/5511940292792)

</div>
<div align="center">
</div>


# marcosaraujo.dev — Blog Engine

Uma engine de blog pessoal minimalista, orientada a alta performance e focada na experiência de leitura técnica sobre **Engenharia de Software, Arquitetura e Segurança de Aplicações**.

---

## Tech Stack & Arquitetura

- **Backend:** Java 17 / Spring Boot 3
- **Frontend:** Thymeleaf + Tailwind CSS + Tailwind Typography
- **Markdown Engine:** Flexmark (conversão Server-Side de Markdown para HTML sanitizado)
- **Design System:** Minimalista, responsivo e adaptado para leitura em telas desktop e mobile.

---

## Funcionalidades da Aplicação Pública

-  **Listagem de Artigos:** Exibição elegante das publicações com metadados e tags.
-  **Leitura individual (SEO-Friendly):** URLs dinâmicas baseadas em slugs.
-  **Renderização Server-Side:** Markdown processado no servidor para carregamento instantâneo.
-  **Página de Contato:** Links diretos e canais de conexão profissional.

---

##  Como Executar Localmente

### Pré-requisitos
- **Java 17+** instalado
- **Maven 3.8+** instalado

### Passos
1. Clone este repositório:
   ```bash
   git clone [https://github.com/marcosaraujodev083-tech/marcosaraujo.dev-blog.git](https://github.com/marcosaraujodev083-tech/marcosaraujo.dev-blog.git)

Acesse a pasta do projeto:

```cd marcosaraujo.dev-blog```

Execute a aplicação via Maven:

```./mvnw spring-boot:run```

Acesse no navegador:

```http://localhost:8080```

Segurança & Integração

Os artigos exibidos nesta aplicação pública são consumidos e atualizados via comunicação autenticada proveniente do painel administrativo privado (marcosaraujo.dev-admin).

---

## Roadmap do Blog Público

### 🟢 Sprint 1: Versão 1.0 — Experiência de Leitura & Estrutura Base

- [x] Configuração base do Spring Boot 3 + Thymeleaf + Tailwind CSS.
- [x] Arquitetura de design minimalista e responsiva (`max-w-xl`, avatar e paleta monocromática).
- [x] Páginas implementadas: Home (listagem), Leitura de Artigos (`/post/{slug}`) e Contato (`/contato`).
- [x] Motor de conversão Server-Side de Markdown para HTML via Flexmark.
- [x] Versionamento do código e publicação inicial no GitHub (`marcosaraujo.dev-blog`).

### 🟡 Próximas Funcionalidades & Evoluções Públicas

- [x] **Cadastro de Newsletter Incluso** Em uma pagina independente
- [ ] **Filtro & Busca por Tags:** Navegação e filtragem de artigos por categoria/tecnologia.
- [x] **Modo Escuro (Dark Mode):** Alternância sutil de tema claro/escuro com persistência de preferência do leitor.
- [x] **Tempo Estimado de Leitura:** Cálculo automático no cabeçalho do post (ex: *"5 min de leitura"*).
- [ ] **Feedback do Leitor:** Botão simples de reação/curtida por artigo sem necessidade de login.
- [ ] **SEO & Open Graph:** Meta tags automáticas para preview enriquecido ao compartilhar links no LinkedIn e Twitter/X.
- [ ] **RSS Feed & Sitemap:** Gerador automático de `feed.xml` e `sitemap.xml` para indexação em motores de busca.