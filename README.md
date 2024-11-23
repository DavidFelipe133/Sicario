# Sicario

# Sistema de Gerenciamento de Serviços - Sicário Segurança Privada

**Status do Projeto**: Em desenvolvimento 🚧

## Apresentação da Empresa
Bem-vindo à **Sicário Segurança Privada**, uma empresa líder na indústria de segurança com uma década de experiência. Oferecemos soluções abrangentes para atender às necessidades específicas de cada cliente. Nosso portfólio inclui serviços como:

- Segurança de eventos
- Carros-fortes
- Segurança comercial e residencial
- Segurança em áreas rurais
- Escolta armada

Estamos prontos para lidar com os desafios mais complexos.

## Descrição do Sistema
Este sistema foi desenvolvido para organizar e controlar os principais processos da Sicário Segurança Privada, incluindo a gestão de clientes, funcionários e agendamentos de serviços. O objetivo principal é aumentar a eficiência operacional e garantir a segurança das operações.

### Estrutura do Sistema
O sistema é baseado em três classes principais de objetos:
1. **Cliente**: Representa os clientes da empresa, armazenando dados como nome, endereço e informações de contato.
2. **Funcionário**: Representa os funcionários da empresa, incluindo dados pessoais e informações relacionadas às suas funções.
3. **Agenda**: Responsável pelo gerenciamento dos serviços agendados, incluindo:
   - Descrição do serviço
   - Horário do serviço
   - Vínculo com um cliente
   - Vínculo com um ou mais funcionários

Os vínculos entre as classes garantem a rastreabilidade das operações e a organização dos serviços.

## Requisitos Funcionais
### 1. Gerenciamento de Clientes
- Cadastro de novos clientes com nome, endereço e detalhes do serviço.
- Visualização e edição das informações dos clientes existentes.
- Exclusão de clientes quando necessário.

### 2. Gerenciamento de Funcionários
- Cadastro de novos funcionários.
- Visualização e edição das informações dos funcionários existentes.
- Exclusão de funcionários quando necessário.

### 3. Agendamento de Serviços
- Cadastro de serviços com descrição, horário e vínculos com clientes e funcionários.
- Visualização, edição e cancelamento de agendamentos.

### 4. Autenticação e Autorização
- Recursos de autenticação para garantir o acesso seguro aos dados.

## Necessidades Observadas e Regras de Negócio
- Registro centralizado de clientes, funcionários e agendamentos de serviços.
- Agendamentos registrados com data, hora específica e descrição do serviço.
- Vinculação de um ou mais funcionários a um único agendamento.
- Garantia de segurança de dados por meio de autenticação.

## Time de Desenvolvedores
- **David Felipe de Oliveira**
