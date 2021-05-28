from queue import SimpleQueue
import math
import timeit

class Graph:

    def __init__(self, matrix: dict):
        self.matrix = matrix

    def addVertex(self, name: str):
        newCol = dict.fromkeys(self.matrix.keys(), 0)

        self.matrix[name] = newCol

        for col, val in self.matrix.items():
            val[name] = 0
    
    def deleteVertex(self, name: str):
        
        del self.matrix[name]

        for col, val in self.matrix.items():
            del val[name]

    def createConnection(self, name1, name2):
        self.matrix[name1][name2] = 1
        self.matrix[name2][name1] = 1

    def deleteConnection(self, name1: str, name2: str):
        self.matrix[name1][name2] = 0
        self.matrix[name2][name1] = 0

    def findVertex(self, vertexName: str) -> bool:
        return True if vertexName in self.matrix else False

    def iterateGraph(self, startFrom: str):

        processed = []

        return self.__getVertex(startFrom, processed)

    def __getVertex(self, currentVertex: str, processed: list):
        
        processed.append(currentVertex)

        for child in self.__getChildren(currentVertex, processed):
            yield from self.__getVertex(child, processed)
        
        yield currentVertex

    def getDistance(self, vertex1: str, vertex2: str) -> int:

        queue = SimpleQueue()
        processed = []

        current = {
            "name": vertex1,
            "level": 0
        }

        queue.put(current)

        while not queue.empty():
            if current["name"] == vertex2:
                return current["level"]
            
            processed.append(current["name"])

            children = self.__getChildren(current["name"], processed)

            for child in children:
                queue.put({"name": child, "level": current["level"] + 1})

            current = queue.get()
        
        return -1

    def __getChildren(self, currentVertex: str, processed = []):
        return sorted(filter(lambda key: not key in processed and self.matrix[currentVertex][key] == 1,
                                self.matrix[currentVertex].keys()))

    def getDiameter(self) -> int:
        distances = []

        processed = []

        for vertexName, vertexValue in self.matrix.items():
            for nextVertexName in vertexValue.keys():

                if (nextVertexName not in processed):
                    distances.append(self.getDistance(vertexName, nextVertexName))
            
            processed.append(vertexName)

        return max(distances)
    
    def getCenter(self) -> dict:

        radius = [{
            "vertexName": None,
            "distance": math.inf
        }]

        for vertexName, vertexValue in self.matrix.items():

            maxDistance = {
                "vertexName": vertexName,
                "distance": 0
            }

            for nextVertex in vertexValue.keys():
                
                distance = self.getDistance(vertexName, nextVertex)

                if distance > maxDistance["distance"]:
                    maxDistance["distance"] = distance
                
            if radius[0]["distance"] == maxDistance["distance"]:
                radius.append(maxDistance)
            elif radius[0]["distance"] > maxDistance["distance"]:
                radius.clear()

                radius.append(maxDistance)
        
        return radius

    def isConnected(self) -> bool:
        
        processed = []

        for vertexName, vertexValue in self.matrix.items():

            processed.append(vertexName)

            for nextVertexName in vertexValue.keys(): 
                
                if nextVertexName not in processed:
                    if self.getDistance(vertexName, nextVertexName) == -1:
                        return False

        return True
    
    def isRegular(self) -> bool:

        current = None

        for vertex in self.matrix.keys():
            if current == None:
                current = self.getDegree(vertex)
            elif self.getDegree(vertex) != current:
                return False
        
        return True

    def getMedian(self) -> dict:

        median = [{
            "vertexName": None,
            "distanceSum": math.inf
        }]

        for vertexName, vertexValue in self.matrix.items():

            current = {
                "vertexName": vertexName,
                "distanceSum": 0
            }

            for nextVertex in vertexValue.keys():
                
                distance = self.getDistance(vertexName, nextVertex)

                current["distanceSum"] += distance
            
            if current["distanceSum"] == median[0]["distanceSum"]:
                median.append(current)
            if current["distanceSum"] < median[0]["distanceSum"]:
                median.clear()
                median.append(current)
        
        return median
    
    def getMutualPredecessor(self, root, vertex1, vertex2) -> str:

        processed = []

        distToFirst = self.getDistance(root, vertex1)
        distToSecond = self.getDistance(root, vertex2)

        current = root

        while True:
            for child in self.__getChildren(current, processed):

                newdistToFirst = self.getDistance(child, vertex1)
                newdistToSecond = self.getDistance(child, vertex2)

                if (newdistToFirst < distToFirst and newdistToSecond < distToSecond):
                    processed.append(current)
                    distToFirst = newdistToFirst
                    distToSecond = newdistToSecond
                    current = child
                    break
            else:
                break
            
        return current

    def getDegree(self, vertex) -> int:
        return len(self.__getChildren(vertex))

    def getEccentricity(self, vertex) -> int:
        
        maxDistance = 0

        for otherVertex in self.matrix[vertex].keys():

            distance = self.getDistance(vertex, otherVertex)

            if distance > maxDistance:
                maxDistance = distance

        return maxDistance