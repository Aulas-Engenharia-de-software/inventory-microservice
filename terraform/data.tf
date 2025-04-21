provider "aws" {
  region = "us-east-1"
}

data "aws_caller_identity" "current" {}

data "aws_availability_zones" "available" {
  state = "available"
}

data "aws_ecs_cluster" "event_drive_cluster" {
  cluster_name = var.ecs_config.cluster_name
}

data "aws_sqs_queue" "order-created-queue" {
  name = "order-created-queue"
}