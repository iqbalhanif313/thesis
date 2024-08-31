provider "aws" {
  region = "us-east-1"  # Change to your region
}

module "eks" {
  source          = "terraform-aws-modules/eks/aws"
  cluster_name    = "kafka-eks-cluster"
  cluster_version = "1.24"
  subnets         = aws_subnet.subnets[*].id
  vpc_id          = aws_vpc.vpc.id

  node_groups = {
    kafka_nodes = {
      desired_capacity = 3
      max_capacity     = 4
      min_capacity     = 2

      instance_type = "m5.large"  # Adjust as per your requirement
    }
  }

  manage_aws_auth = true
}

resource "aws_vpc" "vpc" {
  cidr_block = "10.0.0.0/16"  # Adjust to your desired CIDR block
}

resource "aws_subnet" "subnets" {
  count = 3  # Create 3 subnets for high availability
  vpc_id     = aws_vpc.vpc.id
  cidr_block = cidrsubnet(aws_vpc.vpc.cidr_block, 8, count.index)

  availability_zone = element(data.aws_availability_zones.available.names, count.index)
}

resource "aws_security_group" "eks_security_group" {
  name        = "eks_security_group"
  vpc_id      = aws_vpc.vpc.id

  ingress {
    from_port   = 0
    to_port     = 65535
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}
