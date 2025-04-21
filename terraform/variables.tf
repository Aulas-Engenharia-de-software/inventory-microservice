variable "ecs_config" {
  default = {
    cluster_name = "event-driven-cluster"
    service_name = "inventory-service"
    task_family  = "inventory-service-task"
    cpu          = 256
    memory       = 512
    provider     = "FARGATE"
    ports        = [
      {
        containerPort = 8080,
        hostPort      = 8080
      }
    ]
    logConfiguration = {
      logDriver = "awslogs",
      options   = {
        "awslogs-group"         = "/ecs/inventory-service",
        "awslogs-region"        = "us-east-1",
        "awslogs-stream-prefix" = "ecs"
      }
    }
  }
}

variable "schedulers_config" {
  default = {
    name = "inventory_schedule"

    start_schedule ={
      name = "start_inventory_service"
      expression = "cron(0 19 ? * MON,TUE,THU *)"
      desired_count = 1
    }
    stop_schedule ={
      name = "stop_inventory_service"
      expression = "cron(0 20 ? * MON,TUE,THU *)"
      desired_count = 0
    }
  }
}

variable "app_name" {
  default = "inventory-service"
}

variable "aws_account_id" {
  default = "624676054102"
}

variable "region" {
  default = "us-east-1"
}

variable "ecr_config" {
  default = {
    name                 = "inventory-app"
    image_tag_mutability = "MUTABLE"
    force_delete         = true
    scan_on_push         = true
    tags                 = {
      Name = "inventory-app"
    }
  }
}