# 🎬 Movie Search Java — OMDb API

Aplicação em **Java** que consome a **API OMDb** para buscar informações sobre filmes.  
O sistema permite realizar buscas, exibir detalhes completos, manter um histórico das pesquisas e tratar erros corretamente.

Este projeto foi desenvolvido com foco em **praticar consumo de APIs REST, manipulação de JSON, organização de código e lógica de programação**.

---

## 🚀 Funcionalidades

- 🔍 Buscar filmes pelo nome  
- 📋 Exibir detalhes do filme:
  - Título  
  - Ano de lançamento  
  - Duração  
  - Diretor  
- 🕒 Histórico das buscas  
- ⚠️ Tratamento de erro quando o filme não é encontrado  
- 📑 Menu interativo no terminal  

---

## 🛠️ Tecnologias Utilizadas

- Java 17+  
- API HTTP Client (`java.net.http`)  
- Gson (conversão de JSON)  
- OMDb API  

---

## 📦 Dependência

Este projeto utiliza a biblioteca **Gson**.

Se estiver usando **Maven**, adicione:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
