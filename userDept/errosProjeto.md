# 🛠️ Resumo dos Problemas Corrigidos na Aplicação (Spring Boot + H2)

Este documento descreve os erros encontrados durante a configuração do projeto **Spring Boot + JPA + H2** e como cada 
um deles foi identificado e corrigido até a aplicação funcionar corretamente.

---

## ✅ 1. Erro 404 ao acessar `/h2-console`

**Sintoma:**  
Acessar `http://localhost:8080/h2-console` resultava em **404 Whitelabel Error Page**.

**Causa:**  
O Maven não conseguia baixar dependências essenciais (Spring Boot, H2, JPA) devido ao erro de rede:

``
java.net.SocketException: Connection reset
``

A aplicação subia parcialmente, impedindo o H2 Console de ser inicializado.

**Correção:**
- Criado o arquivo `settings.xml` em `.m2` configurando o Maven Central.
- Excluída a pasta `.m2/repository` para reconstrução completa do cache.
- Usado “Force Update of Snapshots/Releases” no IntelliJ para forçar atualização.

---

## ✅ 2. Maven não encontrava o parent `spring-boot-starter-parent`

**Sintoma:**  
A IDE mostrava:

``
Project spring-boot-starter-parent:3.3.x not found
``

**Causa:**  
O Maven não possuía acesso ao repositório remoto para baixar as versões do Spring Boot.

**Correção:**  
Mesmos passos do item anterior (configuração do Maven + limpeza de cache).

---

## ✅ 3. Avisos vermelhos no log do Java/Tomcat

**Sintomas:**

``
WARNING: A restricted method in java.lang.System has been called
``

**Causa:**  
Java 21 + Tomcat usam APIs nativas (JNI), e o Java exibe warnings de segurança — **não são erros**.

**Correção:**
- Avisos foram explicados; podem ser ignorados com segurança.
- Opcionalmente removíveis com flags de VM (`--enable-native-access`).

---

## ✅ 4. H2 Console conectado ao banco errado

**Sintoma:**  
O H2 Console exibia por padrão:

``
jdbc:h2:~/test
``

**Causa:**  
Esse é o banco padrão do H2, mas sua aplicação estava usando um banco **em memória**:

``
jdbc:h2:mem:testdb
``

**Correção:**  
Substituição manual do JDBC URL na tela do console.

---