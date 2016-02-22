/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.Utilitarios;

/**
 *
 * @author Bruno Barbosa
 */
public class ScriptPopular {
    
    private final String[] professores;
    private final String[] turmas;
    private String[] alunos;
    private String[] disciplinas;
    private String[] questoes;
    private String[] respostas;
    private String[] sqlUpdade;

    public ScriptPopular() {
        String[] professor = {"Roberto","Cesar","Barroso","Eduardo","Jonas","Tulio","Albert","Rodrigues"};
        this.professores = professor;
        String[] turma = {"A1","A2","A3","B1","B2","B3","C1","C2","C3"};
        this.turmas = turma;
        String[] aluno = {"Bruno","Cicero","Jefferson","Gustavo","Lucas","Enzo","Gabriel","Diego","Vitor","Pedro","Leonardo","Rafael",
                                "Matheus","Miguel","Arthur","Joao","Lorenzo","Benjamin","Antonio","Nicolas","Carlos","Daniel","Alexandre",
                                "Jose","Andre","Thiago","Caio","Paulo",
                                "Isabela","Camila","Fernanda","Manuela","Rebeca","Helena","Giovanna","Aline","Isadora","Nicole","Gabriela",
                                "Vanessa","Jessica","Luisa","Lorena","Bianca","Beatriz","Sofia","Julia","Ana","Yasmin","Lara","Mariana","Carolina"};
        this.alunos = aluno;
        String[] disciplina = {"Matematica","Portugues","Ingles","Historia","Geografia","Quimica"};
        this.disciplinas = disciplina;
        String[] questao = {"A planta de um apartamento está confeccionada na escala 1 : 50. Então a área\n"
                                + " real, em m2, de uma sala retangular cujas medidas na planta, são 12 cm e 14 cm é:",
                            "José emprestou R$ 500,00 a João por 5 meses, no sistema de juros simples, a uma taxa de juros fixa e\n"
                                + " mensal. Se no final dos 5 meses José recebeu um total de R$ 600,00, então a taxa fixa mensal\n aplicada foi de:",
                            "Seja r a reta que passa pelos pontos P(1, 0)  e Q(–1, –2). Então, o ponto simétrico de N(1, 2),\n com relação a reta r é:",
            //Port
                            "Percorrendo A casa, deleitando-se com Cordéis e outros \n" +
                            "poemas, você jamais habitará A vinha dos esquecidos. É isso \n" +
                            "aí! Participe deste encontro literário com Natércia Campos, \n" +
                            "Patativa do Assaré e João Clímaco Bezerra. \n" +
                            "Assinale a alternativa cuja afirmação se aplica às três narrativas escolhidas para esta prova.",
                            
                            "Analise as afirmativas quanto às recomendações da norma culta sobre acentuação gráfica.\n" +
                            "I - Tanto imaginou o que se iria passar, que chegou a crê-lo e a vê-lo.\n" +
                            "\n" +
                            "II - Logo depois, seguiu na direção do Largo da Carioca, para entrar num tílburi.\n" +
                            "\n" +
                            "III - A idéia de estarem descobertos parecía-lhe cada vez mais verossimil.\n" +
                            "\n" +
                            "IV - Camilo, em si, reconhecia que podia serví-la por toda uma eternidade.\n" +
                            "\n" +
                            "V - A mesma suspensão das suas visitas apenas com o pretexto futil, trouxe-lhe magoas.\n" +
                            "\n" +
                            "Assinale a alternativa correta.",
                    
                            "Cada alternativa a seguir apresenta um trecho de Memórias póstumas de Brás Cubas em que há a\n"
                            + "presença do acento grave. Assinale a única em que o acento grave está empregado pela mesma\n"
                            + "razão por que foi usado em “desde o emplasto de Brás Cubas / à solda da opinião” (versos 56-57).",
            //Ing    
                            "What is the simple past of the following verbs, respectively?\n" +
                            "\n" +
                            "hurt – bet – run – shake",
                            
                            "The underlined words DO NOT function as determinants in:",
            
                            "How can we do the question tag for: Let‘s go!",
            //His
                            "A conquista de Constantinopla pelos turcos, em 1453, interrompeu o comércio por terra entre a\n"
                            + "Europa e a Ásia, obrigando os europeus a buscarem novas rotas comerciais, agora pelo mar. Esse\n"
                            + "fato beneficiou os países atlânticos e ajudou a deslocar o eixo econômico para a Europa Ocidental.\n"
                            + "Portugal e Espanha tomaram a dianteira nesse processo, que ficou conhecido como expansão marítima.\n" +
                            "\n" +
                            "Além do acontecimento da tomada de Constantinopla e suas decorrências, algumas outras condições\n"
                            + "favoreceram os países ibéricos na expansão marítima, entre elas:",
            
                            "O coronelismo, fenômeno político da Primeira República (1889-1930), tinha como uma de suas\n"
                            + "principais características o controle do voto, o que limitava, portanto, o exercício da\n"
                            + "cidadania. Nesse período, esta prática estava vinculada a uma estrutura social:",
            
                            "O fim da Guerra Fria e da bipolaridade, entre as décadas de 1980 e 1990, gerou expectativas de\n"
                            + "que seria instaurada uma ordem internacional marcada pela redução de conflitos e pela multipolaridade.\n" +
                            "\n" +
                            "O panorama estratégico do mundo pós-Guerra Fria apresenta:",
            //Geo
                            "Sobre a América do Sul é correto afirmar, exceto:",
            
                            "Assinale a alternativa incorreta, quanto aos biomas terrestres.",
            
                            "O debate atual em torno dos biocombustíveis, como o álcool de cana-de-açúcar e o biodiesel, inclui o \n"
                            + "efeito estufa. Tal efeito garante temperaturas adequadas à vida na Terra, mas seu aumento \n"
                            + "indiscriminado é danoso. Com relação a esse aumento, os biocombustíveis são alternativas \n"
                            + "preferíveis aos combustíveis fósseis porque:",
            //Quim
                            "Os alquimistas foram muito importantes para a química, a ciência da transformação. Tentando \n"
                            + "encontrar a pedra filosofal, que teria o poder de transformar qualquer metal em ouro, e o elixir da \n"
                            + "longa vida, que tornaria o ser humano imortal, criaram um grande número de aparelhos de \n"
                            + "laboratório e desenvolveram processos importantes para a produção de metais, de papiros, \n"
                            + "de sabões e de muitas substâncias, como o ácido nítrico, o ácido sulfúrico, o hidróxido de \n"
                            + "sódio e o hidróxido de potássio. Sobre essas substâncias, ácidos e bases, pode-se afirmar que:",
            
                            "Considere as seguintes informações sobre o carbono, um elemento químico fundamental para a \nvida no planeta Terra:\n" +
                            "\n" +
                            "Possui número atômico 6 e é constituído de três isótopos, dois com nuclídeos estáveis, 12C e 13C, e um com nuclídeo instável, o 14C.\n" +
                            "Está presente em substâncias simples que se diferenciam pelo arranjo cristalino.\n" +
                            "Em substâncias compostas, os seus átomos se unem por meio de ligações simples, duplas ou triplas.\n\n"
                            + "Sobre o carbono, assinale a alternativa incorreta.",
            
                            "O elemento césio é da família dos alcalinos. Possui um único isótopo estável (133Cs) e vários \n"
                            + "radioisótopos. Um deles é o 137Cs. A esse respeito, assinale a afirmativa correta."};
        this.questoes = questao;
        String[] resposta = {/*questao 1 Mat (42)*/ "24","26","28","42",
                                    /*q 2 Mat (4%)*/ "0,2%","0,4%","2%","4%",
                                    /*q 3 Mat (3,0)*/ "(0,0)","(3,0)","(5/2,1)","(0,-1)",
                                    /*q 4 Por (A ambientacao...)*/ "Os eventos são narrados em ordem cronológica.",
                                                                    "O desfecho das narrativas já se insinua desde o seu início.",
                                                                    "A ambientação interiorana percorre o enredo das três narrativas.",
                                                                    "A complexidade dos enredos decorre das variações de foco narrativo.",
                                    /*q 5 Por (I e II)*/ "Somente as afirmativas II e IV são verdadeiras.",
                                                        "Somente as afirmativas I e III são verdadeiras.",
                                                        "Somente as afirmativas I e II são verdadeiras.",
                                                        "Somente as afirmativas III, IV e V são verdadeiras.",
                                    /*q 6 Por (O que vc quer e passar...)*/ "Creio que prefere a anedota à reflexão",
                                                                            "Vejo-a assomar à porta da alcova, pálida, comovida",
                                                                            "Dito isto, expirei às duas horas da tarde de uma sexta-feira",
                                                                            "O que você quer é passar mansamente do sótão à sala de jantar",
                                    /*q 7 Ing (hurt, bet, ran, shook)*/ "hurt, bet, run, shaked;",
                                                                        "hurted, betted, shaked;",
                                                                        "hurt, bet, ran, shook",
                                                                        "hurted, bet, runned, shaked",
                                    /*q 8 Ing (ready to reengage with the world)*/ "an accessible and multiethnic nation.",
                                                                                    "an eightminute pitch.",
                                                                                    "ready to reengage with the world.",
                                                                                    "the most compelling message.",
                                    /*q 9 Ing (Shall we?)*/ "does we?","did we?","Shall we?","can’t we?",
                                    /*q 10 His (A centralização política...)*/  "A existência de uma burguesia mercantil forte, responsável pelo financiamento e\n"
                                                                                + "administração do empreendimento marítimo sem a participação do Estado.",
                                                                                "Um sólido conhecimento das rotas do Oceano Atlântico, apesar da inexistência \n"
                                                                                + "de instrumentos seguros de navegação.",
                                                                                "A centralização política e administrativa dos Estados português e espanhol, em torno de\n"
                                                                                + "monarquias absolutistas.",
                                                                                "A disponibilidade de um grande excedente populacional para as viagens marítimas, \n"
                                                                                + "além dos pequenos riscos dessas viagens para as tripulações das embarcações.",
                                    /*q 11 His (agrária, marcada pela...)*/ "igualitária, com um nível satisfatório de distribuição da renda",
                                                                            "estagnada, com uma relativa harmonia entre as classes.",
                                                                            "ditatorial, perturbada por um constante clima de opressão mantido pelo exército\n e polícia.",
                                                                            "agrária, marcada pela concentração da terra e do poder político local e regional.",
                                    /*q 12 His (o aumento de conflitos...)*/ "o aumento de conflitos internos associados ao nacionalismo, às disputas étnicas, ao \n"
                                                                                + "extremismo religioso e ao fortalecimento de ameaças como o terrorismo, o tráfico\n"
                                                                                + "de drogas e o crime organizado.",
                                                                             "o fim da corrida armamentista e a redução dos gastos militares das grandes potências,\n"
                                                                                + "o que se traduziu em maior estabilidade nos continentes europeu e asiático, que tinham\n"
                                                                                + "sido palco da Guerra Fria.",
                                                                             "o desengajamento das grandes potências, pois as intervenções militares em regiões \n"
                                                                                + "assoladas por conflitos passaram a ser realizadas pela Organização das Nações Unidas\n"
                                                                                + "(ONU), com maior envolvimento de países emergentes.",
                                                                             "a plena vigência do Tratado de Não Proliferação, que afastou a possibilidade de um \n"
                                                                                + "conflito nuclear como ameaça global, devido à crescente consciência política\n"
                                                                                + "internacional acerca desse perigo.",
                                    /*q 13 Geo (Apesar de o clima...)*/ "Grande parte do continente apresenta clima tropical quente e chuvoso. Ao longo da \n"
                                                                        + "costa Oeste, as condições são muito mais secas, com clima semi-árido e desértico \n"
                                                                        + "quente em alguns lugares.",
                                                                        "Embora a economia de alguns países dependa de atividades primárias, outros, como \n"
                                                                        + "Brasil, Argentina e Venezuela, também desenvolveram uma série de atividades \n"
                                                                        + "manufatureiras e de alta tecnologia.",
                                                                        "A produção de alimentos para exportação é uma importante fonte de renda para muitos \n"
                                                                        + "países sul-americanos.",
                                                                        "Apesar de o clima ser tropical, existem poucas florestas tropicais no continente, cuja \n"
                                                                        + "população é majoritariamente rural.",
                                    /*q 14 Geo (Nos desertos...)*/  "A taiga se localiza em regiões de clima frio, com invernos rigorosos; nela as \n"
                                                                    + "coníferas predominam.",
                                                                    "Nos desertos predominam as savanas, cujos solos áridos permitem a rápida \n"
                                                                    + "decomposição da matéria orgânica.",
                                                                    "Nos campos, devido à quantidade de chuvas intermediária entre o deserto e a \n"
                                                                    + "floresta, a vegetação que predomina é constituída por gramíneas.",
                                                                    "As florestas tropicais são caracterizadas por uma vegetação que cresce o ano todo, \n"
                                                                    + "devido à luminosidade, temperatura elevada e chuvas frequentes.",
                                    /*q 15 Geo (contribuem para...)*/   "são renováveis e sua queima impede o aquecimento global.",
                                                                        "retiram da atmosfera o CO2 gerado em outras eras.",
                                                                        "contribuem para a diminuição da liberação de carbono, presente nos \n"
                                                                        + "combustíveis fósseis.",
                                                                        "são combustíveis de maior octanagem e de menores taxas de liberação de carbono.",
                                    /*q 16 Qui (na reação entre ácido sulfúrico...)*/   "as fórmulas do ácido nítrico e do ácido sulfúrico são HONO3 e H2SO4, respectivamente;",
                                                                                        "a reação entre ácido nítrico e o ácido sulfúrico conduz à produção de apenas um sal;",
                                                                                        "o hidróxido de sódio não reage com o ácido nítrico, pois se trata de uma base forte;",
                                                                                        "na reação entre ácido sulfúrico e o hidróxido de sódio podem ser formados dois sais;",
                                    /*q 17 Qui (O carbono-14...)*/  "Grafite e diamante são substâncias simples, conhecidas como formas alotrópicas \ndo carbono",
                                                                    "O átomo de carbono possui seis prótons no núcleo",
                                                                    "O carbono-14, usado para a datação de objetos históricos, não é radioativo",
                                                                    "As hibridações sp3, sp2 e sp são características do carbono",
                                    /*q 18 Qui (O Cs é um...)*/ "O 137Cs possui quatro prótons a mais que o 133Cs.",
                                                                "O Cs, sendo um elemento alcalino, reage com a água para formar o hidróxido de fórmula Cs(OH)2.",
                                                                "O Cs é um elemento menos eletronegativo que o oxigênio.",
                                                                "O Cs tem distribuição eletrônica cujo elétron mais externo fica em um orbital d."};
        this.respostas = resposta;
        String[] sqlUpdate =   {"update questao set resposta_id_correta = 4 where id_questao = 1;",
                                    "update questao set resposta_id_correta = 8 where id_questao = 2;",
                                    "update questao set resposta_id_correta = 10 where id_questao = 3;",
                                    "update questao set resposta_id_correta = 15 where id_questao = 4;",
                                    "update questao set resposta_id_correta = 19 where id_questao = 5;",
                                    "update questao set resposta_id_correta = 24 where id_questao = 6;",
                                    "update questao set resposta_id_correta = 27 where id_questao = 7;",
                                    "update questao set resposta_id_correta = 31 where id_questao = 8;",
                                    "update questao set resposta_id_correta = 35 where id_questao = 9;",
                                    "update questao set resposta_id_correta = 39 where id_questao = 10;",
                                    "update questao set resposta_id_correta = 44 where id_questao = 11;",
                                    "update questao set resposta_id_correta = 45 where id_questao = 12;",
                                    "update questao set resposta_id_correta = 52 where id_questao = 13;",
                                    "update questao set resposta_id_correta = 54 where id_questao = 14;",
                                    "update questao set resposta_id_correta = 59 where id_questao = 15;",
                                    "update questao set resposta_id_correta = 64 where id_questao = 16;",
                                    "update questao set resposta_id_correta = 67 where id_questao = 17;",
                                    "update questao set resposta_id_correta = 71 where id_questao = 18;"};
        this.sqlUpdade = sqlUpdate;
    }

    
    public String[] getProfessores() {
        return professores;
    }

    public String[] getTurmas() {
        return turmas;
    }

    public String[] getAlunos() {
        return alunos;
    }

    public String[] getDisciplinas() {
        return disciplinas;
    }

    public String[] getQuestoes() {
        return questoes;
    }

    public String[] getRespostas() {
        return respostas;
    }

    public String[] getSqlUpdade() {
        return sqlUpdade;
    }
    
    
}
