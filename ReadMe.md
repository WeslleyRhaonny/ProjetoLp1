# Projeto - Cadastro Acadêmico

**Disciplina:** Linguagem de Programação 1

**Professora:** Prof. Dra. Danielle Rousy Dias Ricarte

**Equipe:** 
- ELIANE SANTOS SILVA
- HERICK DE LIMA CARNEIRO
- JOÃO VICTOR LOURENÇO DA SILVA
- WESLLEY RHAONNY DE LIMA FREITAS

## INTRODUÇÃO

  O projeto descrito a seguir tem como objetivo criar um sistema de gerenciamento escolar (cadastro acadêmico), em que é possível realizar um cadastro de usuários definidos em três tipos: alunos, professores e funcionários administrativos, fornecendo acesso à informações como, por exemplo, folhas de pagamento, histórico acadêmico e alunos de uma determinada turma.
  
  A princípio, o programa elaborado oferece um menu interativo que permite escolher entre diversas opções. Nesse primeiro contato, as opções de 1 a 3 permitem cadastrar diferentes tipos de usuários, podendo inserir informações necessárias para a ação como: nome, email, número de telefone, entre outras.
  
  As opções de 4 a 7, de modo geral, fornecem acesso aos dados já cadastrados no programa. A opção 8, "Folha de pagamento", permite calcular e exibir informações relacionadas aos salários dos funcionários: os valores a serem pagos e o seu salário bruto. A opção 9 permite pesquisar um usuário específico, onde é lido um nome e são exibidas todas as informações disponíveis sobre o usuário em particular.
  
  As opções 10 e 11 são voltadas, especificamente, a alunos. Enquanto a opção 10 permite cadastrar as notas de um aluno específico em disciplinas ou avaliações, a opção 11 permite visualizar o histórico acadêmico de um aluno, mostrando todas as notas que foram cadastradas no sistema.
  
  Por fim, a opção 0 encerra o programa. Esse sistema de gerenciamento escolar foi desenvolvido com a linguagem de programação Java e busca facilitar a administração e organização dos dados e processos acadêmicos, oferecendo uma interface simples e intuitiva por linha de comando. Dessa forma, a solução elaborada será descrita, de maneira mais detalhada, em seguida.

## MODELAGEM DO PROBLEMA

  De forma prévia à estruturação das classes, foi pensado nos elementos que iriam compor o sistema, incluindo os que foram propostos em caráter obrigatório. Após isso, houve uma análise de como poderíamos tratar esses elementos, definindo-os como classes padrões, interfaces, ou classes abstratas, visto que são critérios que deveriam ser abordados no projeto. Diante disso, foi elaborado um diagrama de classes que pode ser visualizado no Anexo 1 deste documento.
  
  Para melhor entendimento, existem alguns pontos que devem ser ressaltados:
  
- Herança: Abordando o conceito de herança, as classes “Funcionário” e “Aluno” herdam a classe “Usuario” e as classes “Professor” e “Administrativo” herdam a classe “Funcionario”;
- Turma e Professor: Cada professor pode estar associado apenas a 2 turmas em turnos diferentes e cada turma possui apenas um único professor;
- Turma e Aluno: Cada aluno possui apenas 1 turma. Em uma turma, pode existir vários alunos;
- Aluno e Disciplina: Cada aluno possui 5 disciplinas em seu histórico, obrigatoriamente.

  Ademais, como padrão definido pela equipe, é válido citar que, ao inserir notas dos alunos (opção 10 do menu), é necessário utilizar o padrão decimal brasileiro para que a nota seja aplicada.
  

