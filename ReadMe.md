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

  De forma prévia à estruturação das classes, foi pensado nos elementos que iriam compor o sistema, incluindo os que foram propostos em caráter obrigatório. Após isso, houve uma análise de como poderíamos tratar esses elementos, definindo-os como classes padrões, interfaces, ou classes abstratas, visto que são critérios que deveriam ser abordados no projeto. Diante disso, foi elaborado um diagrama de classes que pode ser visualizado logo abaixo:

![diagramaAtualizado](https://github.com/WeslleyRhaonny/ProjetoLp1/assets/97205293/6b82dbe4-3a96-4393-9787-60683fe4d247)
<div align="center">
<img src="https://github.com/WeslleyRhaonny/ProjetoLp1/assets/97205293/6b82dbe4-3a96-4393-9787-60683fe4d247" width="0px" />
</div>
  
  Para melhor entendimento, existem alguns pontos que devem ser ressaltados:
  
- Herança: Abordando o conceito de herança, as classes “Funcionário” e “Aluno” herdam a classe “Usuario” e as classes “Professor” e “Administrativo” herdam a classe “Funcionario”;
- Turma e Professor: Cada professor pode estar associado apenas a 2 turmas em turnos diferentes e cada turma possui apenas um único professor;
- Turma e Aluno: Cada aluno possui apenas 1 turma. Em uma turma, pode existir vários alunos;
- Aluno e Disciplina: Cada aluno possui 5 disciplinas em seu histórico, obrigatoriamente.

  Ademais, como padrão definido pela equipe, é válido citar que, ao inserir notas dos alunos (opção 10 do menu), é necessário utilizar o padrão decimal brasileiro para que a nota seja aplicada.
  
## FERRAMENTAS UTILIZADAS

No desenvolvimento do projeto, foram utilizadas diversas ferramentas que desempenharam um papel fundamental na criação e gestão do código fonte. As principais ferramentas adotadas foram o Visual Studio Code, IntelliJ, Eclipse, Git e GitHub.

As IDEs utilizadas no projeto foram o Visual Studio Code, IntelliJ e Eclipse. Essas ferramentas foram escolhidas devido à sua reputação como editores de código fonte altamente versáteis e populares. Cada uma delas oferece uma ampla gama de recursos e extensões que possibilitaram uma experiência de programação eficiente. Com destaque para o realce de sintaxe, depuração avançada e integração com sistemas de controle de versão como o Git. Essas IDEs proporcionaram um ambiente de desenvolvimento robusto e intuitivo, permitindo-nos escrever, testar e depurar o código com facilidade, aumentando assim a produtividade e a qualidade do projeto.

O Git foi utilizado como sistema de controle de versão distribuído. Ele permitiu o acompanhamento e gerenciamento eficiente das alterações realizadas no código fonte ao longo do tempo. Com o Git, foi possível trabalhar em equipe e mesclar as alterações de forma segura. Essa ferramenta foi essencial para manter o histórico de alterações, facilitando a colaboração e garantindo a integridade do código.

Para hospedar o código e facilitar a colaboração com outros desenvolvedores, foi utilizado o GitHub. O GitHub proporcionou um ambiente colaborativo, onde a equipe pôde revisar o código, realizar solicitações de pull e manter tudo documentado e acessível para toda a equipe.

Em conjunto, essas ferramentas proporcionaram um ambiente de desenvolvimento robusto e eficaz. Elas contribuíram para a produtividade da equipe, a gestão eficiente do código fonte, a colaboração entre os membros e a garantia da qualidade do software.

Um exemplo de gestão eficiente de código proporcionado pelas IDEs pode ser exposto pela facilidade em estruturar pacotes. No referido projeto, foi utilizada uma estruturação simples para separar classes de controle, usuários (professor, aluno e administrativo) e classes voltadas aos dados acadêmicos (disciplinas, notas). De maneira resumida, pode-se observar como estão organizados os pacotes de acordo com a imagem abaixo:

![novoDiagrama](https://github.com/WeslleyRhaonny/ProjetoLp1/assets/97205293/f60bdfd0-6b43-4ace-bad1-95f5e550bdd3)
<div align="center">
<img src="https://github.com/WeslleyRhaonny/ProjetoLp1/assets/97205293/f60bdfd0-6b43-4ace-bad1-95f5e550bdd3" width="0px" />
</div>

## RESULTADOS E CONSIDERAÇÕES FINAIS
  
Durante o desenvolvimento do projeto de gerenciamento escolar (cadastro acadêmico), alcançamos resultados significativos em relação à implementação da solução proposta. O sistema permitiu o cadastro de alunos, professores e funcionários administrativos, além de fornecer acesso a dados relevantes, como informações dos alunos, turmas, professores, administrativos, folha de pagamento e histórico acadêmico. Através do menu interativo, os usuários podem realizar diversas ações de forma intuitiva e eficiente.

Ao longo do desenvolvimento, enfrentamos algumas dificuldades. Uma delas foi a complexidade de lidar com a estruturação de classes e a interação entre elas. O paradigma de programação orientada a objetos (OO) exigiu uma compreensão aprofundada dos conceitos de encapsulamento, herança e polimorfismo, bem como a aplicação correta desses conceitos na construção do sistema. A organização e modularização do código também foram desafios a serem superados para garantir a manutenção e escalabilidade do projeto.

No que diz respeito à aprendizagem da linguagem Java e do paradigma OO, o projeto proporcionou uma valiosa experiência de imersão. Através do desenvolvimento prático, pudemos consolidar os conhecimentos teóricos adquiridos ao longo da disciplina de Linguagem de Programação I. Aprofundamos nossa compreensão sobre os princípios da OO, como encapsulamento, herança, polimorfismo e abstração, e suas aplicações na resolução de problemas reais. A familiarização com a sintaxe e recursos da linguagem Java foi um passo importante no caminho de nos tornarmos programadores mais habilidosos e proficientes.

Em considerações finais, gostaríamos de expressar nosso feedback sobre a disciplina de Linguagem de Programação I. O conteúdo e a abordagem da disciplina foram essenciais para a nossa formação como futuros profissionais. Através das aulas teóricas e práticas, fomos capazes de compreender os conceitos fundamentais da programação e aplicá-los em projetos reais. As atividades práticas, como o desenvolvimento deste projeto, foram de extrema importância para solidificar o aprendizado e aprimorar nossas habilidades de resolução de problemas.

