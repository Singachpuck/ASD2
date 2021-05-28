import json
from graph import Graph
from timeit import timeit

with open("testGraph.json", "r") as incidenceMatrixFile:
    incidenceMatrix = json.load(incidenceMatrixFile)

    graph = Graph(incidenceMatrix)

    #graph.addVertex("point21")

    # print(timeit(lambda: graph.addVertex("point21"), number=1))
    # print(timeit(lambda: graph.addVertex("point22"), number=1))
    # print(timeit(lambda: graph.addVertex("point23"), number=1))
    # print(timeit(lambda: graph.addVertex("point24"), number=1))
    # print(timeit(lambda: graph.addVertex("point25"), number=1))

    # graph.createConnection("point21", "point11")

    # for i in range(20):
    #     print(timeit(lambda: graph.deleteVertex("point" + str(i)), number=1))
        

    # print(timeit(lambda: graph.createConnection("point6", "point11"), number=1))
    # print(timeit(lambda: graph.deleteConnection("point6", "point11"), number=1))
    # print(timeit(lambda: graph.createConnection("point0", "point1"), number=1))
    # print(timeit(lambda: graph.deleteConnection("point0", "point1"), number=1))
    # print(timeit(lambda: graph.createConnection("point11", "point17"), number=1))
    # print(timeit(lambda: graph.deleteConnection("point17", "point11"), number=1))
    # print(timeit(lambda: graph.createConnection("point20", "point8"), number=1))
    # print(timeit(lambda: graph.deleteConnection("point20", "point8"), number=1))

    # for i in range(20, 0, -1):
    #     print(timeit(lambda: graph.iterateGraph("point" + str(i)), number=1))
    #     graph.deleteVertex("point" + str(i))

    # print(timeit(lambda: graph.createConnection("point21", "point11"), number=1))

    # #print(graph.getDistance("point21", "point17"))

    # print(timeit(lambda: graph.getDistance("point21", "point17"), number=1))


    # # print(graph.findVertex("point100"))

    # print(timeit(lambda: graph.findVertex("point100"), number=1))


    # # for vertex in graph.iterateGraph("point0"):
    # #     print(vertex)

    # print(timeit(lambda: graph.iterateGraph("point0"), number=1))

    # # print("Діаметер графа: ", graph.getDiameter())
    # print(timeit(graph.getDiameter, number=1))
    # # print("Центр графа: ", graph.getCenter())
    # print(timeit(graph.getCenter, number=1))
    # # print("Медіана графа: ", graph.getMedian())
    # print(timeit(graph.getMedian, number=1))
    # # print("Зв'язний: ", graph.isConnected())
    # print(timeit(graph.isConnected, number=1))
    # # print("Регулярний: ", graph.isRegular())
    # print(timeit(graph.isRegular, number=1))

    # print("Степінь точки 2: ", graph.getDegree("point2"))
    # print(timeit(lambda: graph.getDegree("point2"), number=1))
    # print("Екцентриситет точки 2: ", graph.getEccentricity("point2"))
    # print(timeit(lambda: graph.getEccentricity("point2"), number=1))

    # # graph.deleteVertex("point21")

    # print(timeit(lambda: graph.deleteVertex("point21"), number=1))

    # #print(timeit(graph.getMedian, number=1))

    # print(timeit(lambda: graph.getDistance("point2", "point3"), number=1))
    # print(timeit(lambda: graph.getDistance("point8", "point3"), number=1))
    # print(timeit(lambda: graph.getDistance("point6", "point3"), number=1))
    # print(timeit(lambda: graph.getDistance("point13", "point3"), number=1))
    # print(timeit(lambda: graph.getDistance("point0", "point13"), number=1))
    # print(timeit(lambda: graph.getDistance("point18", "point13"), number=1))
    # print(timeit(lambda: graph.getDistance("point17", "point13"), number=1))

    print(timeit(lambda: graph.getMutualPredecessor("point2", "point2", "point8"), number=1))
    print(timeit(lambda: graph.getMutualPredecessor("point2", "point14", "point6"), number=1))
    print(timeit(lambda: graph.getMutualPredecessor("point19", "point15", "point12"), number=1))

