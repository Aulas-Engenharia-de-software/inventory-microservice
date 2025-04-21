locals {
  task_environment_vars = [
    {
      name  = "AWS_REGION",
      value = var.region
    },
    {
      name = "ORDER_CREATED_QUEUE_NAME"
      value = data.aws_sqs_queue.order-created-queue.name
    }
  ]
}